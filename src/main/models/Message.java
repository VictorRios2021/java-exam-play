package main.models;

import java.util.Date;

/**
 * class message use if is required ... insert db etc
 * @author victorrios
 */
public class Message {

    private String id;
    private String message;
    private Date date;
    private String checksum;
    private String device;


    public Message(String[] messageFormat, String device) {
        this.id = messageFormat[0];
        this.message = messageFormat[1];
        this.date = new Date();
        this.checksum = messageFormat[2];
        this.device = device;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public String getChecksum() {
        return checksum;
    }

    public String getDevice() {
        return device;
    }


    
}
