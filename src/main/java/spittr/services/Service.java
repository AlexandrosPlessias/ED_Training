package spittr.services;

import java.sql.SQLException;

// T stands for generic<T>
public interface Service<T> {

    // Create methods By T.
    T create(T t) ;

    // Read methods by ID.
    T read(Long id) ;

    // Update methods.
    T update(Long id, String updateText) ;

    // Delete methods by ID.
    boolean delete(Long id) ;

    // Delete methods by T.
    boolean delete(T t);

}
