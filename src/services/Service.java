package services;

import java.sql.SQLException;

// T stands for generic<T>
public interface Service<T> {

    // Create methods.
    void create(T t) throws SQLException, ClassNotFoundException, IllegalAccessException;

    // Read methods.
    void read(T t) throws SQLException, ClassNotFoundException, IllegalAccessException;

    // Update methods.
    void update(T t, String updateText) throws SQLException, ClassNotFoundException, IllegalAccessException;

    // Delete methods.
    void delete(T t) throws SQLException, ClassNotFoundException, IllegalAccessException;

}
