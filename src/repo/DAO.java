package repo;

// Data Access Object Pattern FOR Spitter.
// dummy class not impl yet.
public interface DAO {

    void create(Object obj); // Perform DB Delete
    void read(Object obj);  // Perform DB Delete
    void update(Object obj, String updateText);    // Perform DB Delete
    void delete(Object obj);    // Perform DB Delete
}



