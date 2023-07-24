package main;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import main.utils.MessageValidator;

/**
 *  Class to listen serial port, and receive messages with format id#message#checksum
 * @author victorrios
 */

public class SerialPortListener implements Runnable{
    
    public SerialPort serialPort;
    private String portName;
    private boolean portIddle = false;
    private long lastMessageTime = System.nanoTime();
    

    public SerialPortListener(String portName) {
        this.portName = portName;

    }
    

    public void run() {
        serialPort = new SerialPort(portName);

        try {
            serialPort.openPort();
            Logger.getLogger(SerialPortListener.class.getName()).log(Level.INFO, "Puerto: "+portName+" Opened");
            
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
 
            serialPort.addEventListener(new SerialPortReader(), SerialPort.MASK_RXCHAR);
            timer();
            

        } catch (SerialPortException ex) {
             Logger.getLogger(SerialPortListener.class.getName()).log(Level.SEVERE, ex.getMessage());
             Thread.interrupted();
        }
    }
    
    /**
     * Timer detect inactivity and show that the device is offline after 3s
     */
    public void timer(){
        Timer timer = new Timer();
        
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run(){
                long currentTime = System.nanoTime();
                long dif = currentTime - lastMessageTime;
                double difTimeSecs = (double) dif / 1_000_000_000;
                
                if(difTimeSecs >= 3 && portIddle == false){
                    Logger.getLogger(SerialPortListener.class.getName()).log(Level.SEVERE, "Offline device: "+ portName);
                    portIddle = true;
                }
            }  
        };
        timer.schedule(timerTask, 0, 3000);
    } 

    

    private class SerialPortReader implements SerialPortEventListener{
        
        @Override
        public void serialEvent(SerialPortEvent event) {
            
            if (event.isRXCHAR()) {
                lastMessageTime = System.nanoTime();
                portIddle = false;
                String receivedData;
                try {
                    receivedData = serialPort.readString(event.getEventValue()).trim();
                    String portName = serialPort.getPortName();
                    
                    
                    boolean isValidFormat = MessageValidator.isValidFormat(receivedData);
              
                    if(isValidFormat){
                        String[] receivedDataSplit = receivedData.split("#");
                        String id = receivedDataSplit[0];
                        String message = receivedDataSplit[1];
                        String checksum = receivedDataSplit[2];
                        Date date = new Date();
                        
                        
                        boolean isValidChecksum = MessageValidator.isValidChecksum( message, checksum);
                        
                        if(isValidChecksum) {
                            String resp = String.format("%s %s %s %s",
                                date.toString(), 
                                message, 
                                portName, 
                                checksum);  
                            Logger.getLogger(SerialPortListener.class.getName()).log(Level.INFO, resp);
                        } else {
                            Logger.getLogger(SerialPortListener.class.getName()).log(Level.SEVERE, "Checksum invalid");
                        }
                      
                    } else {
                         Logger.getLogger(SerialPortListener.class.getName()).log(Level.SEVERE, "Invalid message: "+ receivedData+ ", from port: "+ portName);
                    }          
                } catch (SerialPortException ex) {
                    Logger.getLogger(SerialPortListener.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
    }
}

