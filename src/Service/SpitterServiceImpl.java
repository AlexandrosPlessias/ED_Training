package Service;

import DomainClasses.Spitter;
import DomainClasses.Spittle;

import java.util.Date;


public class SpitterServiceImpl implements Service {


    @Override
    public Spitter create(String username, String password, String email, String firstName, String lastName, String description){
        // Spitter sp = SpitterDAOImpl.Create(username, password, email, firstName, lastName,  description)
        return null; // will be replaced.
    }

    @Override
    public void read(Spitter spitter){
        // data = call SpitterDAOImpl.read(spitter);
        // System.out.println(data);
    }

    @Override
    public Spitter update(Spitter spitter, String description){ // what update?? description
        // Spitter sp = SpitterDAOImpl.update(description);
        // System.out.println("Updated successfully!");
        return null;
    }


    @Override
    public boolean delete(Spitter spitter){
        // SpitterDAOImpl.detele(spitter);

        //if (element exist) {perform delete; System.out.println("{Element} deleted successfully!");}
        // else System.err.println("Delete Fails!");
        return true;
    }


    //DUMMY METHODS

    @Override
    public Spittle create(String message, Date date, Double latitude, Double longitude) {
        return null;
    }

    @Override
    public void read(Spittle spittle) {

    }

    @Override
    public Spittle update(Spittle spittle, String message) {
        return null;
    }

    @Override
    public boolean delete(Spittle spittle) {
        return false;
    }
}
