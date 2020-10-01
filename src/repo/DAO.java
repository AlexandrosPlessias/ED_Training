package repo;

import java.sql.SQLException;

// Data Access Object Pattern FOR Spitter.
// DAO<T t>
//SpittleDao implements DAO<Spittle>



public interface DAO<T> {

    T create(T t) throws SQLException, ClassNotFoundException; // Perform DB Delete
    T read(Long id) throws SQLException, ClassNotFoundException;  // Perform DB Delete
    T update(Long id, String updateText) throws SQLException, ClassNotFoundException;    // Perform DB Delete
    boolean delete(Long id) throws SQLException, ClassNotFoundException;    // Perform DB Delete
    boolean delete(T t) throws SQLException, ClassNotFoundException;    // Perform DB Delete
}



