package Service;

import DAO.DAO;
import DomainClasses.Spitter;
import DomainClasses.Spittle;

import java.util.Date;

/**
 * Here will implemented the CRUD methods for Spittle
 *  and Spittle.
 */
public class Service {

    // used for Singleton Pattern.
    private static Service singleton = new Service( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Service() { }

    /* Static 'instance' method */
    public static Service getInstance( ) {
        return singleton;
    }

    // Create methods
    public Spitter createSpitter(String username, String password, String email, String firstName, String lastName, String description){
        // Spitter sp = SpitterDAOImpl.Create(username, password, email, firstName, lastName,  description)
        return null; // will be replaced.
    }

    public Spittle createSpittle(String message, Date date, Double latitude, Double longitude){
        // Spittle sp = SpittleDAOImpl.Create (message, date, latitude, longitude)
        return null; // will be replaced.
    }



    // read methods
    public void readSpitter(Spitter spitter){
        // data = call SpitterDAOImpl.read(spitter);
        // System.out.println(data);
    }

    public void readSpittle(Spittle spittle){
        // data =  SpittleDAOImpl.read(spitter);
        // System.out.println(data);
    }


    // update methods
    public Spitter updateSpitter(Spitter spitter, String description){ // what update?? description
        // Spitter sp = SpitterDAOImpl.update(description);
        // System.out.println("Updated successfully!");
        return null;
    }

    public Spittle updateSpittle(Spittle spittle, String message){ // what update?? message
        // Spittle sp = SpittleDAOImpl.update(message);
        // System.out.println("Updated successfully!");
        return null;
    }


    // delete methods.
    public boolean deleteSpitter(Spitter spitter){
        // SpitterDAOImpl.detele(spitter);

        //if (element exist) {perform delete; System.out.println("{Element} deleted successfully!");}
        // else System.err.println("Delete Fails!");
        return true;
    }

    public boolean deleteSpittle(Spittle spittle){
        // SpittleDAOImpl.detele(spittle);

        //if (element exist) {perform delete; System.out.println("{Element} deleted successfully!");}
        // else System.err.println("Delete Fails!");
        return true;
    }

}
