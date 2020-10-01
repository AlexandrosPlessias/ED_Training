package persistence;

import domain.Spitter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class SpitterDAOHibernateImpl implements DAO<Spitter> {

    private static SessionFactory factory;

    //Constructor.
    public SpitterDAOHibernateImpl (){

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public Spitter create(Spitter spitter) throws SQLException, ClassNotFoundException {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            spitter = (Spitter) session.save(spitter);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return spitter;
    }

    @Override
    public Spitter read(Long id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Spitter update(Long id, String updateText) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Spitter spitter) throws SQLException, ClassNotFoundException {
        return false;
    }
}
