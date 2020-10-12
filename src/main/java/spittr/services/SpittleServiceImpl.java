package spittr.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spittr.config.JPAconfig;
import spittr.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spittr.persistence.DAO;
import spittr.persistence.SpittleDAOHibernateImpl;
import spittr.repositories.SpitterRepository;
import spittr.repositories.SpittleRepository;

import java.sql.SQLException;
import java.util.List;

@Component
public class SpittleServiceImpl implements Service<Spittle>{

    //private DAO spittleDAO;
    private SpittleRepository spittleRepository;

    public SpittleServiceImpl(/*SpittleDAOHibernateImpl spittleDAOHibernate */) {
        //this.spittleDAO = new SpittleDAOImpl();
        //this.spittleDAO = (DAO) new SpittleDAOHibernateImpl();
        //this.spittleDAO = spittleDAOHibernate;
        ApplicationContext jpaContext = new AnnotationConfigApplicationContext(JPAconfig.class);
        spittleRepository = jpaContext.getBean(SpittleRepository.class);
    }

    @Override
    public Spittle create(Spittle spittle) {
        // Not null check
        if (spittle.valid()){
            //return (Spittle) this.spittleDAO.create(spittle);
            return spittleRepository.save(spittle);
        } else {
            System.err.println("Service violation: Null object tried to created...");
            return null;
        }

    }

    @Override
    public Spittle read(Long id){
        // Not null check
        if (id != null) {

            if (spittleRepository.existsById(id)){
                //return (Spittle) this.spittleDAO.read(id);
                return spittleRepository.getOne(id);
            } else {
                System.err.println("Service violation: Tweet/Spittle don't exists...");
                return null;
            }

        }else{
            System.err.println("Service violation: Null object tried to read...");
            return null;
        }
    }

    @Override
    public Spittle update(Long id, String updateText)  {
        // Not null check
        if (id != null){

            if( spittleRepository.setSpitterMessageById(id,updateText)>=1){
                //return (Spittle) this.spittleDAO.update(id, updateText);
                return spittleRepository.getOne(id);
            } else {
                System.err.println("Service violation: Tweet/Spiitle don't exists...");
                return null;
            }

        }else{
            System.err.println("Service violation: Null object or messsage tried to update a record...");
            return null;
        }

    }

    @Override
    public boolean delete(Long id) {
        // Not null check
        if (id != null){

            if (spittleRepository.existsById(id)){
                //return this.spittleDAO.delete(id);
                spittleRepository.deleteById(id);
                return true;
            } else {
                System.err.println("Service violation: Tweet/Spiitle don't exists...");
                return false;
            }
        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }

    @Override
    public boolean delete(Spittle spittle)  {
        // Not null check
        if (spittle.valid()){

            if (spittleRepository.existsById(spittle.getId())){
                //return this.spittleDAO.delete(spittle);
                spittleRepository.delete(spittle);
                return true;
            } else {
                System.err.println("Service violation: Tweet/Spittle don't exists...");
                return false;
            }

        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }


    public List<Spittle> getAll(){

        List<Spittle> allTweets = spittleRepository.findAll();

        if (allTweets == null){
            System.err.println("Service INFO: No tweets exists...");
        }

        return allTweets;

    }
}
