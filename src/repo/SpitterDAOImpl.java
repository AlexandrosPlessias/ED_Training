package repo;

import domain.Spitter;

// dummy class not impl yet for Spitter.
public class SpitterDAOImpl implements DAO {

    @Override
    public void create(Object obj) {

        Spitter sp = (Spitter) obj;
        String query = "INSERT INTO spitter (username, password, email, firstname, lastname, description) " +
                       "VALUES ("+sp.getUsername()+","+sp.getPassword()+","+sp.getEmail()+","+sp.getFirstName()+"," +
                                ","+sp.getLastName()+","+sp.getDescription()+")";

        // execute query.

        System.out.println("Spitter entry added to DB Successfully");
    }

    @Override
    public void read(Object obj) {

        Spitter sp = (Spitter) obj;
        String query = "SELECT * FROM spitter WHERE idSpitter = " +sp.getId();

        // execute query.

        System.out.println("Spitter entry read was Successfully from DB");
    }

    @Override
    public void update(Object obj, String updateText) {

        Spitter sp = (Spitter) obj;
        String query = "UPDATE spitter SET descrition = "+updateText+" WHERE idSpitter = " +sp.getId();

        // execute query.

        System.out.println("Spitter entry Update to DB was Successfully");
    }

    @Override
    public void delete(Object obj) {

        Spitter sp = (Spitter) obj;
        String query = "DELETE FROM spitter WHERE idSpitter = " +sp.getId();

        // execute query.

        System.out.println("Spitter entry Deleted Successfully from DB");
    }
}
