package services;


import repo.DAO;
import repo.SpitterDAOImpl;

import java.sql.SQLException;

public class SpitterServiceImpl implements Service {

    private DAO spitterDAO ;

    public SpitterServiceImpl() {
        this.spitterDAO = new SpitterDAOImpl();
    }

    @Override
    public void create(Object obj) throws SQLException, ClassNotFoundException {
        spitterDAO.create(obj);
    }

    @Override
    public void read(Object obj) throws SQLException, ClassNotFoundException {
        spitterDAO.read(obj);
    }

    @Override
    public void update(Object obj, String updateText) throws SQLException, ClassNotFoundException {
        spitterDAO.update(obj, updateText);
    }

    @Override
    public void delete(Object obj) throws SQLException, ClassNotFoundException {
        spitterDAO.delete(obj);

    }
}
