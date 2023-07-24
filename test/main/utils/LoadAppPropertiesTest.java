package main.utils;

import java.util.Properties;
import static main.JavaApplication.LIST_SERIAL_PORTS;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victorrios
 */
public class LoadAppPropertiesTest {
    
    
    
    public LoadAppPropertiesTest() {
    }

    /**
     * Test of getProperties method, of class LoadAppProperties.
     */
    @Test
    public void testGetProperties() throws Exception {
        System.out.println("getProperties");
        Properties result = LoadAppProperties.getProperties();
        assertNotNull(result.getProperty(LIST_SERIAL_PORTS));
    }
    
}
