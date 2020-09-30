package services;


import domain.Spitter;
import repo.DAO;
import repo.SpitterDAOImpl;
import java.sql.SQLException;

// Genetic became from <T> to Spitter.
public class SpitterServiceImpl implements Service<Spitter> {

    private DAO spitterDAO ;

    public SpitterServiceImpl() {
        this.spitterDAO = new SpitterDAOImpl();
    }


    @Override
    public void create(Spitter spitter) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
         if (!spitter.checkNull()){
             spitterDAO.create(spitter);
         }
    }

    @Override
    public void read(Spitter spitter) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (!spitter.checkNull()) {
            spitterDAO.read(spitter);
        }
    }

    @Override
    public void update(Spitter spitter, String updateText) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (!spitter.checkNull()) {
            spitterDAO.update(spitter, updateText);
        }
    }

    @Override
    public void delete(Spitter spitter) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // Not null check
        if (!spitter.checkNull()) {
            spitterDAO.delete(spitter);
        }
    }

}
