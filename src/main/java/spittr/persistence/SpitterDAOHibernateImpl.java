package spittr.persistence;

import spittr.domain.Spitter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class SpitterDAOHibernateImpl implements DAO<Spitter> {

    private final SessionFactory sessionFactory;
    private Transaction transaction = null;
    private Session session = null;


    public SpitterDAOHibernateImpl (){

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
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
        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            spitter = null;
            hibernateExceptionEx.printStackTrace();
        } finally {
            session.close();
        }

        if (spitter != null) {
            System.out.println("User "+spitter.getId()+" created.");
        }else {
            System.out.println("User already exists. created.");
        }

        return spitter;
    }

    public Spitter read(Long id) {

        session = sessionFactory.openSession();
        Spitter user = null;

        try {
            transaction = session.beginTransaction();
            user = session.get(Spitter.class, id);
            transaction.commit();
        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            hibernateExceptionEx.printStackTrace();
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

    public Spitter update(Long id, String updateText)  {

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

        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            hibernateExceptionEx.printStackTrace();
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

    public boolean delete(Long id) {

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

        } catch (HibernateException hibernateExceptionEx) {
            transaction.rollback();
            hibernateExceptionEx.printStackTrace();
        } finally {
            session.close();
        }

        if (deleteFlag){
            System.out.println("User " + id + " deleted Successfully...");
        }else{
            System.err.println("User " + id + " Don't found in DB.");
        }

        return deleteFlag;
    }

    public boolean delete(Spitter spitter) {
        return delete(spitter.getId());
    }
}
