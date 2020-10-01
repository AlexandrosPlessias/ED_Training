package domain;

import java.lang.reflect.Field;
import java.sql.Date;

// Tweet msg data & loc & timestamp.
public class Spittle {

    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;
    private Long ownerId;

    // Empty constructor.
    public Spittle(){

    }

    public Spittle(Long id, String message, Date date, Double latitude, Double longitude, Long ownerId) {
        this.id = id;
        this.ownerId = ownerId;
        this.message = message;
        this.time = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(String message, Date date, Double latitude, Double longitude, Long ownerId) {
        this.id = null;
        this.message = message;
        this.time = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ownerId = ownerId;
    }


    // Getters
    public Long getId() {
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

    public Long getOwnerId() {
        return ownerId;
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage (String newMessage){
        this.message = newMessage;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", ownerId=" + ownerId +
                '}';
    }

    // Class for NULL Checking...
    public boolean checkNull() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) != null)
                return false;
        return true;
    }
}
