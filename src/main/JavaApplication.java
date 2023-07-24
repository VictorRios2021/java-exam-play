package main;

import java.io.FileNotFoundException;
import java.io.IOException;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.utils.LoadAppProperties;


public class JavaApplication {
    
    public final static String LIST_SERIAL_PORTS = "LIST_SERIAL_PORTS";


    public static void main( String[] args ) throws FileNotFoundException, IOException {
        
        /* get port names (macos) 
        String[] portNames = SerialPortList.getPortNames("/dev/", Pattern.compile("tty\\..*"));
        for (String portName : portNames) {
            System.out.println(portName);
        }
        */
        
        Properties prop = LoadAppProperties.getProperties();
        String serialPorts = prop.getProperty(LIST_SERIAL_PORTS);
        
        if(serialPorts.isEmpty()) {
            Logger.getLogger(JavaApplication.class.getName()).log(Level.INFO, "Add LIST_SERIAL_PORTS in AppSetting.properties File");
            return;
        }
        
        System.out.println(serialPorts);
        String[] listSerialPorts = serialPorts.split(",");

        ExecutorService executorService = Executors.newCachedThreadPool();
        
        for(String SerialPort: listSerialPorts) {
            if(!SerialPort.isEmpty()){
                SerialPortListener sp = new SerialPortListener(SerialPort); 
                executorService.execute(sp);
            } 
        }

    }

}

