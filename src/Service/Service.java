package Service;

import DomainClasses.Spitter;
import DomainClasses.Spittle;
import java.util.Date;

public interface Service {

    // Create methods.
    public Spitter create(String username, String password, String email, String firstName, String lastName, String description);
    public Spittle create(String message, Date date, Double latitude, Double longitude);

    // Read methods.
    public void read(Spitter spitter);
    public void read(Spittle spittle);

    // Update methods.
    public Spitter update(Spitter spitter, String description);
    public Spittle update(Spittle spittle, String message);

    // Delete methods.
    public boolean delete(Spitter spitter);
    public boolean delete(Spittle spittle);

}
