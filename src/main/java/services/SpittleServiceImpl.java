package services;

import domain.Spittle;
import persistence.DAO;
import persistence.SpittleDAOHibernateImpl;

import java.sql.SQLException;

public class SpittleServiceImpl implements Service<Spittle>{

    private DAO spittleDAO;

    public SpittleServiceImpl() {
        //this.spittleDAO = new SpittleDAOImpl();
        this.spittleDAO = new SpittleDAOHibernateImpl();
    }

    @Override
    public Spittle create(Spittle spittle) throws SQLException, ClassNotFoundException {
        // Not null check
        if (spittle.valid()){
            return (Spittle) this.spittleDAO.create(spittle);
        } else {
            System.err.println("Service violation: Null object tried to created...");
            return null;
        }

    }

    @Override
    public Spittle read(Long id) throws SQLException, ClassNotFoundException {
        // Not null check
        if (id != null) {
            return (Spittle) this.spittleDAO.read(id);
        }else{
            System.err.println("Service violation: Null object tried to read...");
            return null;
        }
    }

    @Override
    public Spittle update(Long id, String updateText) throws SQLException, ClassNotFoundException {
        // Not null check
        if (id != null){
            return (Spittle) this.spittleDAO.update(id, updateText);
        }else{
            System.err.println("Service violation: Null object or messsage tried to update a record...");
            return null;
        }

    }

    @Override
    public boolean delete(Long id) throws SQLException, ClassNotFoundException {
        // Not null check
        if (id != null){
            return this.spittleDAO.delete(id);
        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }

    @Override
    public boolean delete(Spittle spittle) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (spittle.valid()){
            return this.spittleDAO.delete(spittle);
        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }


}
