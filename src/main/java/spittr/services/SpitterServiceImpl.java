package spittr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spittr.config.JPAconfig;
import spittr.domain.Spitter;
import org.springframework.stereotype.Component;
import spittr.persistence.DAO;
import spittr.persistence.SpitterDAOHibernateImpl;
import spittr.repositories.SpitterRepository;


import java.sql.SQLException;

@Component
public class SpitterServiceImpl implements Service<Spitter> {

    //private DAO spitterDAO ;
    private SpitterRepository spitterRepository;

    public SpitterServiceImpl() {

        //this.spitterDAO = new SpitterDAOImpl();
        //this.spitterDAO = (DAO) new SpitterDAOHibernateImpl(); // Switch from JDBC to Hibernate.
        //this.spitterDAO = spitterDAOHibernate;
        ApplicationContext jpaContext = new AnnotationConfigApplicationContext(JPAconfig.class);
        spitterRepository = jpaContext.getBean(SpitterRepository.class);

    }


    public Spitter create(Spitter spitter)  {
        // Not null check
         if (spitter.valid() ){
             if (spitterRepository.existsByIdOrEmail(spitter.getId(), spitter.getEmail())){
                 System.err.println("Service violation: User or mail already exist.");
                 return null;
             } else {
                 //return (Spitter) spitterDAO.create(spitter);
                 return spitterRepository.save(spitter);
             }
         } else {
             System.err.println("Service violation: Null object tried to created...");
             return null;
         }

    }

    public Spitter read(Long id) {
        // Not null check
        if (id != null){
            if (spitterRepository.existsById(id)){
                //return (Spitter) spitterDAO.read(id);
                return spitterRepository.getOne(id);
            } else {
                System.err.println("Service violation: User don't exists...");
                return null;
            }

        } else {
            System.err.println("Service violation: Null object tried to read...");
            return null;
        }
    }

    public Spitter update(Long id, String updateText)  {
        // Not null check
        if (id != null && updateText != null) {
            // return (Spitter) spitterDAO.update(id, updateText);
            if (spitterRepository.setSpitterInfoById(id, updateText) >=1 ){
                return spitterRepository.getOne(id);
            } else {
                System.out.println("Service violation: User dont exists...");
                return null;
            }
        } else {
            System.err.println("Service violation: Null object or message tried to update a record...");
            return null;
        }
    }

    public boolean delete(Long id)  {
        // Not null check
        if (id != null) {

            if (spitterRepository.existsById(id)){
                //return spitterDAO.delete(id);
                spitterRepository.deleteById(id);
                return true;
            } else {
                System.err.println("Service violation: User don't exist...");
                return false;
            }

        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }

    public boolean delete(Spitter spitter)  {
        // Not null check
        if (spitter.valid() && spitter.getId()!=null) {

            if (spitterRepository.existsById(spitter.getId())){
                // return spitterDAO.delete(spitter.getId());
                spitterRepository.delete(spitter);
                return true;
            } else {
                System.err.println("Service violation: User don't exist...");
                return false;
            }
        }else{
            System.err.println("Service violation: Try to delete Null object...");
            return false;
        }
    }

    public Spitter findByUsername (String username) {

        Spitter user = spitterRepository.findByUsername(username);

        if (user == null){
            System.err.println("Service violation: User don'e exist.");
        }
        return user;
    }

}
