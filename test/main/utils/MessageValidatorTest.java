package main.utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victorrios
 */
public class MessageValidatorTest {
    
    private final String[] data =  {"1", "7A", "120"};
    
    public MessageValidatorTest() {
    }
    

    /**
     * Test of isValidFormat method, of class MessageValidator.
     */
    @Test
    public void testIsValidFormat() {
        System.out.println("isValidFormat true");
        String message = "3#ACK#122";
        boolean expResult = true;
        boolean result = MessageValidator.isValidFormat(message);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isValidFormat method, of class MessageValidator.
     */
    @Test
    public void testIsValidFormatError() {
        System.out.println("isValidFormat false");
        String message = "3#ACK122";
        boolean expResult = false;
        boolean result = MessageValidator.isValidFormat(message);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidChecksum method, of class MessageValidator.
     */
    @Test
    public void testIsValidChecksum() {
        System.out.println("isValidChecksum true");
        boolean expResult = true;
        boolean result = MessageValidator.isValidChecksum( data[1], data[2]);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of isValidChecksum method, of class MessageValidator.
     */
    @Test
    public void testIsValidChecksumError() {
        System.out.println("isValidChecksum false");
        boolean expResult = false;
        boolean result = MessageValidator.isValidChecksum("AAA", data[2]);
        assertEquals(expResult, result);
    }
    
}
