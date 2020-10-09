package spittr.persistence;

import spittr.domain.Spittle;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SpittleDAOHibernateImpl implements DAO<Spittle> {

    private final SessionFactory sessionFactory;
    private Transaction transaction = null;
    private Session session = null;


    //Constructor.
    public SpittleDAOHibernateImpl (){

        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    public Spittle create(Spittle spittle) {

        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(spittle);
            transaction.commit();
        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            hibernateExceptionEx.printStackTrace();
        } finally {
            session.close();
        }

        System.out.println("Tweet "+spittle.getId()+" created.");
        return spittle;
    }

    public Spittle read(Long id)  {
        session = sessionFactory.openSession();
        Spittle tweet = null;

        try {
            transaction = session.beginTransaction();
            tweet = session.get(Spittle.class, id);
            transaction.commit();
        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            hibernateExceptionEx.printStackTrace();
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


    public Spittle update(Long id, String updateText)  {
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

        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            hibernateExceptionEx.printStackTrace();
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

    public boolean delete(Long id)  {

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

        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            hibernateExceptionEx.printStackTrace();
        } finally {
            session.close();
        }

        if (deleteFlag){
            System.out.println("Tweet " + id + " deleted Successfully...");
        }else{
            System.err.println("Tweet " + id + " Don't found in DB.");
        }

        return deleteFlag;
    }

    public boolean delete(Spittle spittle) {
        return delete(spittle.getId());
    }
}
