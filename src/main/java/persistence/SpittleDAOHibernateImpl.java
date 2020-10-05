package persistence;

import domain.Spittle;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class SpittleDAOHibernateImpl implements DAO<Spittle> {

    private SessionFactory sessionFactory;
    private Transaction transaction = null;
    private Session session = null;


    //Constructor.
    public SpittleDAOHibernateImpl (){

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Spittle create(Spittle spittle) throws SQLException, ClassNotFoundException {

        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(spittle);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        System.out.println("Tweet "+spittle.getId()+" created.");
        return spittle;
    }

    public Spittle read(Long id) throws SQLException, ClassNotFoundException {
        session = sessionFactory.openSession();
        Spittle tweet = null;

        try {
            transaction = session.beginTransaction();
            tweet = session.get(Spittle.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (tweet != null){
            System.out.println("Tweet " + tweet.getId() + " Readied/Loaded Successfully...");
        }else{
            System.err.println("Tweet " + id + " Don't found in DB.");
        }

        return tweet;
    }


    public Spittle update(Long id, String updateText) throws SQLException, ClassNotFoundException {
        session = sessionFactory.openSession();
        Spittle tweet = null;

        try {
            transaction = session.beginTransaction();

            // GET -> SET -> UPDATE
            tweet = session.get(Spittle.class, id); //Retrieving object which we want to update

            if (tweet != null){
                tweet.setMessage(updateText); //Set the updated field text.
                session.update(tweet); //Update to the database table.
                transaction.commit();
            }

        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println(e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        if (tweet != null){
            System.out.println("Tweet " + tweet.getId() + " Description updated Successfully...");
        }else{
            System.err.println("Tweet " + id + " Don't found in DB.");
        }

        return tweet;

    }

    public boolean delete(Long id) throws SQLException, ClassNotFoundException {

        boolean deleteFlag = false;
        session = sessionFactory.openSession();
        Spittle tweet = null;

        try {
            transaction = session.beginTransaction();
            tweet = session.get(Spittle.class, id);

            if (tweet != null){
                session.delete(tweet);
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
            System.out.println("Tweet " + id + " deleted Successfully...");
        }else{
            System.err.println("Tweet " + id + " Don't found in DB.");
        }

        return deleteFlag;
    }

    public boolean delete(Spittle spittle) throws SQLException, ClassNotFoundException {
        return delete(spittle.getId());
    }
}
