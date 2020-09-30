package services;

import java.sql.SQLException;

public interface Service {

    // Create methods.
    void create(Object obj) throws SQLException;

    // Read methods.
    void read(Object obj) throws SQLException;

    // Update methods.
    void update(Object obj, String upadateText);

    // Delete methods.
    void delete(Object obj);

}
