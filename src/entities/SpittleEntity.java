package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "spittle", schema = "spittr_db", catalog = "")
public class SpittleEntity {
    private int idSpittle;
    private String message;
    private Timestamp time;
    private double latitude;
    private double longitude;

    @Id
    @Column(name = "idSpittle", nullable = false)
    public int getIdSpittle() {
        return idSpittle;
    }

    public void setIdSpittle(int idSpittle) {
        this.idSpittle = idSpittle;
    }

    @Basic
    @Column(name = "message", nullable = false, length = 180)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "latitude", nullable = false, precision = 0)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = false, precision = 0)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpittleEntity that = (SpittleEntity) o;
        return idSpittle == that.idSpittle &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(message, that.message) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSpittle, message, time, latitude, longitude);
    }
}
