package repo;

import java.sql.SQLException;

// Data Access Object Pattern FOR Spitter.
// DAO<T t>
//SpittleDao implements DAO<Spittle>



public interface DAO<T> {

    void create(T t) throws SQLException, ClassNotFoundException; // Perform DB Delete
    void read(T t) throws SQLException, ClassNotFoundException;  // Perform DB Delete
    void update(T t, String updateText) throws SQLException, ClassNotFoundException;    // Perform DB Delete
    void delete(T t) throws SQLException, ClassNotFoundException;    // Perform DB Delete
}



