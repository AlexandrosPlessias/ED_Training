package services;

import java.sql.SQLException;

// T stands for generic<T>
public interface Service<T> {

    // Create methods By T.
    T create(T t) throws SQLException, ClassNotFoundException, IllegalAccessException;

    // Read methods by ID.
    T read(Long id) throws SQLException, ClassNotFoundException, IllegalAccessException;

    // Update methods.
    T update(Long id, String updateText) throws SQLException, ClassNotFoundException, IllegalAccessException;

    // Delete methods by ID.
    boolean delete(Long id) throws SQLException, ClassNotFoundException, IllegalAccessException;

    // Delete methods by T.
    boolean delete(T t) throws SQLException, ClassNotFoundException, IllegalAccessException;

}
