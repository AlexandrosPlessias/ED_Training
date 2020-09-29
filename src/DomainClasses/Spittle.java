package DomainClasses;

import java.util.Date;

// Tweet msg data & loc & timestamp.
public class Spittle {

    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date date, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = date;
        this.latitude = latitude;
        this.longitude = longitude;
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

}
