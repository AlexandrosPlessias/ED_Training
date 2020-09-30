package domain;

import java.lang.reflect.Field;
import java.sql.Date;

// Tweet msg data & loc & timestamp.
public class Spittle {

    private static int count = 0;
    private final int id;
    private String message;
    private final Date time; // calendar date
    private Double latitude;
    private Double longitude;

    public Spittle(int id, String message, Date date, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(String message, Date date, Double latitude, Double longitude) {
        this.id = count++;
        this.message = message;
        this.time = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLontitude() {
        return longitude;
    }

    // Setter
    public void setMessage (String newMessage){
        this.message = newMessage;
    }

    // Class for NULL Checking...
    public boolean checkNull() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) != null)
                return false;
        return true;
    }
}
