package services;

import repo.DAO;
import repo.SpittleDAOImpl;

import java.sql.SQLException;

public class SpittleServiceImpl implements Service{

    private DAO spittleDAO;

    public SpittleServiceImpl() {
        this.spittleDAO = new SpittleDAOImpl();
    }

    @Override
    public void create(Object obj) throws SQLException, ClassNotFoundException {
        this.spittleDAO.create(obj);
    }

    @Override
    public void read(Object obj) throws SQLException, ClassNotFoundException {
        this.spittleDAO.read(obj);
    }

    @Override
    public void update(Object obj, String updateText) throws SQLException, ClassNotFoundException {
        this.spittleDAO.update(obj, updateText);
    }

    @Override
    public void delete(Object obj) throws SQLException, ClassNotFoundException {
        this.spittleDAO.delete(obj);

    }
}
