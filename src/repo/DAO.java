package repo;

import java.sql.SQLException;

// Data Access Object Pattern FOR Spitter.
public interface DAO {

    void create(Object obj) throws SQLException; // Perform DB Delete
    void read(Object obj) throws SQLException;  // Perform DB Delete
    void update(Object obj, String updateText);    // Perform DB Delete
    void delete(Object obj);    // Perform DB Delete
}



