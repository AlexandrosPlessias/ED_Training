package Service;

import DomainClasses.Spitter;
import DomainClasses.Spittle;
import java.util.Date;

public class SpittleServiceImpl implements Service{


    @Override
    public Spittle create(String message, Date date, Double latitude, Double longitude){
        // Spittle sp = SpittleDAOImpl.Create (message, date, latitude, longitude)
        return null; // will be replaced.
    }


    @Override
    public void read(Spittle spittle){
        // data =  SpittleDAOImpl.read(spitter);
        // System.out.println(data);
    }


    @Override
    public Spittle update(Spittle spittle, String message){ // what update?? message
        // Spittle sp = SpittleDAOImpl.update(message);
        // System.out.println("Updated successfully!");
        return null;
    }


    @Override
    public boolean delete(Spittle spittle){
        // SpittleDAOImpl.delete(spittle);

        //if (element exist) {perform delete; System.out.println("{Element} deleted successfully!");}
        // else System.err.println("Delete Fails!");
        return true;
    }


    // DYMMU METHODS.
    @Override
    public Spitter create(String username, String password, String email, String firstName, String lastName, String description) {
        return null;
    }

    @Override
    public void read(Spitter spitter) {

    }

    @Override
    public Spitter update(Spitter spitter, String description) {
        return null;
    }

    @Override
    public boolean delete(Spitter spitter) {
        return false;
    }
}
