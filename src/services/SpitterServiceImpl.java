package services;


import repo.DAO;
import repo.SpitterDAOImpl;

import java.sql.SQLException;

public class SpitterServiceImpl implements Service {

    @Override
    public void create(Object obj) throws SQLException {
        DAO spitterDAO = new SpitterDAOImpl();
        spitterDAO.create(obj);
    }

    @Override
    public void read(Object obj) throws SQLException {
        DAO spitterDAO = new SpitterDAOImpl();
        spitterDAO.read(obj);
    }

    @Override
    public void update(Object obj, String updateText) {
        DAO spitterDAO = new SpitterDAOImpl();
        spitterDAO.update(obj, updateText);
    }

    @Override
    public void delete(Object obj) {
        DAO spitterDAO = new SpitterDAOImpl();
        spitterDAO.delete(obj);

    }
}
