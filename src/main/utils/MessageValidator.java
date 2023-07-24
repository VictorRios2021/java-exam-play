package main.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to validate received message from serial port
 * @since 21-07-2023
 * @author victorrios
 */
public class MessageValidator {
    
    /**
     * Validate message  ...#message#... from serial port with regex
     * @param message String message from serial port
     * @return Boolean
     */
    public static boolean isValidFormat(String message) {

        Pattern pattern = Pattern.compile("^[0-9]+#[0-9A-Za-z]+#[0-9]+$", Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(message);

        return matcher.matches();
    }
    
    /**
     * Calculate checksum from message and compare with checksum received checksuMessage
     * @param message message received
     * @param checksuMessage checksum received
     * @return Boolean if is valid
     */
    public static boolean isValidChecksum(String message, String checksuMessage) {
        
        int checksumCalculated = 0;  
        for (int i = 0; i < message.length(); i++){  
            char ch = message.charAt(i);  
            int chInt = ch;
            checksumCalculated += chInt;
        }  
       
        if(checksumCalculated == Integer.parseInt(checksuMessage)){
            return true;
        }
        return false;   
    }
    
}
