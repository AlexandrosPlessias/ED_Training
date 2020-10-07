package services;

import domain.Spitter;
import org.springframework.stereotype.Component;
import persistence.DAO;
import persistence.SpitterDAOHibernateImpl;
import persistence.SpitterDAOImpl;
import persistence.SpittleDAOImpl;

import java.sql.SQLException;

@Component
public class SpitterServiceImpl implements Service<Spitter> {

    private DAO spitterDAO ;

    public SpitterServiceImpl(SpitterDAOHibernateImpl spitterDAOHibernate) {

        //this.spitterDAO = new SpitterDAOImpl();
        //this.spitterDAO = (DAO) new SpitterDAOHibernateImpl(); // Switch from JDBC to Hibernate.
        this.spitterDAO = spitterDAOHibernate;
    }

    public SpitterServiceImpl(SpitterDAOImpl simpleSpitterDAO) {

        //this.spitterDAO = new SpitterDAOImpl();
        //this.spitterDAO = (DAO) new SpitterDAOHibernateImpl(); // Switch from JDBC to Hibernate.
        this.spitterDAO = simpleSpitterDAO;
    }


    public Spitter create(Spitter spitter) throws SQLException, ClassNotFoundException {
        // Not null check
         if (spitter.valid() ){
             return (Spitter) spitterDAO.create(spitter);
         } else {
             System.err.println("Service violation: Null object tried to created...");
             return null;
         }

    }

    public Spitter read(Long id) throws SQLException, ClassNotFoundException {
        // Not null check
        if (id != null){
            return (Spitter) spitterDAO.read(id);
        } else {
            System.err.println("Service violation: Null object tried to read...");
            return null;
        }
    }

    public Spitter update(Long id, String updateText) throws SQLException, ClassNotFoundException {
        // Not null check
        if (id != null && updateText != null) {
            return (Spitter) spitterDAO.update(id, updateText);
        } else {
            System.err.println("Service violation: Null object or message tried to update a record...");
            return null;
        }
    }

    public boolean delete(Long id) throws SQLException, ClassNotFoundException {
        // Not null check
        if (id != null) {
            return spitterDAO.delete(id);
        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }

    public boolean delete(Spitter spitter) throws SQLException, ClassNotFoundException {
        // Not null check
        if (spitter.valid()) {
            return spitterDAO.delete(spitter);
        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }


}
