package domain;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.sql.Date;

// Tweet msg data & loc & timestamp.
@Entity
@Table(name = "spittle", schema = "spittr_db")
public class Spittle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpittle", unique = true, nullable = false)
    private Long id;

    @Column(name = "message", nullable = false, length = 180)
    private String message;

    @Column(name = "time", nullable = false)
    private Date time;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "idSpitter", nullable = false)
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
