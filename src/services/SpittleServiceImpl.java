package services;

import domain.Spittle;
import repo.DAO;
import repo.SpittleDAOImpl;

import java.sql.SQLException;

public class SpittleServiceImpl implements Service<Spittle>{

    private DAO spittleDAO;

    public SpittleServiceImpl() {
        this.spittleDAO = new SpittleDAOImpl();
    }

    @Override
    public void create(Spittle spittle) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (!spittle.checkNull()) {
            this.spittleDAO.create(spittle);
        }
    }

    @Override
    public void read(Spittle spittle) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (!spittle.checkNull()) {
            this.spittleDAO.read(spittle);
        }
    }

    @Override
    public void update(Spittle spittle, String updateText) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (!spittle.checkNull()) {
            this.spittleDAO.update(spittle, updateText);
        }
    }

    @Override
    public void delete(Spittle spittle) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (!spittle.checkNull()) {
            this.spittleDAO.delete(spittle);
        }

    }
}
