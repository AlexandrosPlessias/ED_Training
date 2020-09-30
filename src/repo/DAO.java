package repo;

import java.sql.SQLException;

// Data Access Object Pattern FOR Spitter.
public interface DAO {

    void create(Object obj) throws SQLException, ClassNotFoundException; // Perform DB Delete
    void read(Object obj) throws SQLException, ClassNotFoundException;  // Perform DB Delete
    void update(Object obj, String updateText) throws SQLException, ClassNotFoundException;    // Perform DB Delete
    void delete(Object obj) throws SQLException, ClassNotFoundException;    // Perform DB Delete
}



