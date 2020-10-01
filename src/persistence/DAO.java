package persistence;

import java.sql.SQLException;

// The purpose of your application's persistence layer is to use a session (see Section 86.1.1, "Sessions")
// at run time to associate mapping metadata (see Section 2.4.3.1, "Mapping Metadata") and a data source
// (see Section 86.1.2, "Data Access") in order to create, read, update, and delete persistent objects
// using the TopLink cache (see Section 86.1.3, "Cache"), queries and expressions (see Section 86.1.4,
// "Queries and Expressions"), as well as transactions (see Section 86.1.5, "Transactions").


public interface DAO<T> {

    T create(T t) throws SQLException, ClassNotFoundException; // Perform DB Delete
    T read(Long id) throws SQLException, ClassNotFoundException;  // Perform DB Delete
    T update(Long id, String updateText) throws SQLException, ClassNotFoundException;    // Perform DB Delete
    boolean delete(Long id) throws SQLException, ClassNotFoundException;    // Perform DB Delete
    boolean delete(T t) throws SQLException, ClassNotFoundException;    // Perform DB Delete
}



