package main.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victorrios
 */
public class LoadAppProperties {
    private static final String CONFIG_FILE_PATH = "src/AppSettings.properties";

            
    public static Properties getProperties() throws IOException{
        Properties prop = new Properties();

        FileInputStream propsInput = null;
        try {
            propsInput = new FileInputStream(CONFIG_FILE_PATH);
            prop = new Properties();
            prop.load(propsInput);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadAppProperties.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                propsInput.close();
            } catch (IOException ex) {
                Logger.getLogger(LoadAppProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prop;
    }
}
