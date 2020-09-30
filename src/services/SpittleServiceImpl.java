package services;

import repo.DAO;
import repo.SpittleDAOImpl;

import java.sql.SQLException;

// DAO CREATE HERE STO CONSTRATUR.
public class SpittleServiceImpl implements Service{

    @Override
    public void create(Object obj) throws SQLException {
        DAO spittleDAO = new SpittleDAOImpl();
        spittleDAO.create(obj);
    }

    @Override
    public void read(Object obj) throws SQLException {
        DAO spittleDAO = new SpittleDAOImpl();
        spittleDAO.read(obj);
    }

    @Override
    public void update(Object obj, String upadateText) {
        DAO spittleDAO = new SpittleDAOImpl();
        spittleDAO.update(obj, upadateText);
    }

    @Override
    public void delete(Object obj) {
        DAO spittleDAO = new SpittleDAOImpl();
        spittleDAO.delete(obj);

    }
}
