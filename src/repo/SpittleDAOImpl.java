package repo;

import domain.Spittle;

// dummy class not impl yet for Spittle.
public class SpittleDAOImpl implements DAO{

    @Override
    public void create(Object obj) {

        Spittle sptl = (Spittle) obj;
        String query = "INSERT INTO spittle (message, time, latitude, longitude) " +
                "VALUES ("+sptl.getMessage()+","+ sptl.getTime()+","+ sptl.getLatitude()+
                ","+sptl.getLontitude()+")";

        // execute query.

        System.out.println("Spittle entry added to DB Successfully");

    }

    @Override
    public void read(Object obj) {

        Spittle sptl = (Spittle) obj;
        String query = "SELECT * FROM spittle WHERE idSpitter = " +sptl.getId();

        // execute query.

        System.out.println("Spittle entry read was Successfully from DB");
    }

    @Override
    public void update(Object obj, String updateText) {

        Spittle sptl = (Spittle) obj;
        String query = "UPDATE spittle SET descrition = "+updateText+" WHERE idSpitter = " +sptl.getId();

        // execute query.

        System.out.println("Spittle entry Update to DB was Successfully");
    }

    @Override
    public void delete(Object obj) {

        Spittle sptl = (Spittle) obj;
        String query = "DELETE FROM spittle WHERE idSpitter = " + sptl.getId();

        // execute query.

        System.out.println("Spitter entry Deleted Successfully from DB");
    }
}
