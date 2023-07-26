/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victorrios
 */
public class SerialPortListenerTest {
    
    public SerialPortListenerTest() {
    }
    
 

    /**
     * Test of run method, of class SerialPortListener.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        
        SerialPortListener sp = new SerialPortListener("/dev/ttys003"); 
        sp.run();
        assertNotNull(sp);
    }
    
}
