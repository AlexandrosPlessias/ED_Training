package services;

import java.sql.SQLException;

public interface Service {

    // Create methods.
    void create(Object obj) throws SQLException, ClassNotFoundException;

    // Read methods.
    void read(Object obj) throws SQLException, ClassNotFoundException;

    // Update methods.
    void update(Object obj, String upadateText) throws SQLException, ClassNotFoundException;

    // Delete methods.
    void delete(Object obj) throws SQLException, ClassNotFoundException;

}
