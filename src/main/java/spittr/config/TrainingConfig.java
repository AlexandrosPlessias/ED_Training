package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spittr.persistence.SpitterDAOHibernateImpl;
import spittr.persistence.SpittleDAOHibernateImpl;
import spittr.services.SpitterServiceImpl;
import spittr.services.SpittleServiceImpl;

@Configuration
public class TrainingConfig {

    @Bean
    public SpitterDAOHibernateImpl spitterDAOHibernate (){
        return new SpitterDAOHibernateImpl();
    }

    @Bean
    public SpittleDAOHibernateImpl spittleDAOHibernate(){
        return new SpittleDAOHibernateImpl();
    }

    @Bean
    public SpitterServiceImpl spitterService(SpitterDAOHibernateImpl spitterDAOHibernate){
        return new SpitterServiceImpl(spitterDAOHibernate);
    }

    @Bean
    public SpittleServiceImpl spittleService(SpittleDAOHibernateImpl spittleDAOHibernate){
        return new SpittleServiceImpl(spittleDAOHibernate);
    }

}
