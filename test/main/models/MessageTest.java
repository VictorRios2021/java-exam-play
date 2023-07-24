package main.models;

import java.util.Date;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author victorrios
 */
public class MessageTest {
    
    private static Message messageInstance;
    private final String portName = "/dev/ttys003";
    private final String[] data =  {"1", "CKA", "122"};
    
    public MessageTest() {
    }
    
    @Before
    public void setUpClass() {
        messageInstance = new Message(data, portName);
    }
    

    /**
     * Test of setId method, of class Message.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "2";
        messageInstance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(id, messageInstance.getId());
    }

    /**
     * Test of setMessage method, of class Message.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "AAL";
        messageInstance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(message, messageInstance.getMessage());
    }

    /**
     * Test of setDate method, of class Message.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = new Date();
        messageInstance.setDate(date);
        assertEquals(date, messageInstance.getDate());
    }

    /**
     * Test of setChecksum method, of class Message.
     */
    @Test
    public void testSetChecksum() {
        System.out.println("setChecksum");
        String checksum = "222";
        messageInstance.setChecksum(checksum);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(checksum, messageInstance.getChecksum());
    }

    /**
     * Test of setDevice method, of class Message.
     */
    @Test
    public void testSetDevice() {
        System.out.println("setDevice");
        String device = "/dev/ttys005";
        messageInstance.setDevice(device);
        assertEquals(device, messageInstance.getDevice());
    }

    /**
     * Test of getId method, of class Message.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = data[0];
        String result = messageInstance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMessage method, of class Message.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        String expResult = data[1];
        String result = messageInstance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Message.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Date result = messageInstance.getDate();
        assertNotNull(result);
    }

    /**
     * Test of getChecksum method, of class Message.
     */
    @Test
    public void testGetChecksum() {
        System.out.println("getChecksum");
        String expResult = data[2];
        String result = messageInstance.getChecksum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDevice method, of class Message.
     */
    @Test
    public void testGetDevice() {
        System.out.println("getDevice");
        String expResult = portName;
        String result = messageInstance.getDevice();
        assertEquals(expResult, result);
    }
    
}
