package persistence;

import domain.Spitter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.SQLException;

public class SpitterDAOHibernateImpl implements DAO<Spitter> {

    private final String configXML = "src\\main\\java\\hibernate.cfg.xml";
    private SessionFactory sessionFactory;
    private Transaction transaction = null;
    private Session session = null;

    //Constructor.
    public SpitterDAOHibernateImpl (){

        try {
            sessionFactory = new Configuration().configure(new File(configXML)).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Spitter create(Spitter spitter) {

        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(spitter);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        System.out.println("User "+spitter.getId()+" created.");
        return spitter;
    }

    public Spitter read(Long id) {

        session = sessionFactory.openSession();
        Spitter user = null;

        try {
            transaction = session.beginTransaction();
            user = session.get(Spitter.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (user != null){
            System.out.println("User " + user.getId() + " Readied/Loaded Successfully...");
        }else{
            System.err.println("User " + id + " Don't found in DB.");
        }

        return user;
    }

    public Spitter update(Long id, String updateText) throws SQLException, ClassNotFoundException {

        session = sessionFactory.openSession();
        Spitter user = null;

        try {
            transaction = session.beginTransaction();

            // GET -> SET -> UPDATE
            user = session.get(Spitter.class, id); //Retrieving object which we want to update

            if (user != null){
                user.setDescription(updateText); //Set the updated field text.
                session.update(user); //Update to the database table.
                transaction.commit();
            }

        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (user != null){
            System.out.println("User " + user.getId() + " Description updated Successfully...");
        }else{
            System.err.println("User " + id + " Don't found in DB.");
        }

        return user;

    }

    public boolean delete(Long id) throws SQLException, ClassNotFoundException {

        boolean deleteFlag = false;
        session = sessionFactory.openSession();
        Spitter user = null;

        try {
            transaction = session.beginTransaction();
            user = session.get(Spitter.class, id);

            if (user != null){
                session.delete(user);
                transaction.commit();
                deleteFlag = true;
            }

        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (deleteFlag == true){
            System.out.println("User " + id + " deleted Successfully...");
        }else{
            System.err.println("User " + id + " Don't found in DB.");
        }

        return deleteFlag;
    }

    public boolean delete(Spitter spitter) throws SQLException, ClassNotFoundException {
        return delete(spitter.getId());
    }
}
