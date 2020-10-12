package spittr.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.domain.Spitter;

import java.util.List;

    /*
    Miniature domain-specific language (DSL) where persistence details are expressed in repository method signatures.

    get, find, read, count --> Query Verb / Function.
    by                -->
    properties --> Subjects.Properties/Predicate.

    e.g.:  readSpitterByFirstnameOrLastname().

    read -->   Query Verb
    Spitter -->Subjects
    byFirstnameOrLastname --> Predicate
     */

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Long> {

    @Modifying
    @Transactional
    @Query("update Spitter sp set sp.description = ?2 where sp.id = ?1")
    int setSpitterInfoById(Long id, String updatedDesc);

    boolean existsByIdOrEmail(Long id, String email);

    //Spitter findById(long id);
    //Spitter findByUsername(String username);
   // @Query("select s from Spitter s  where s.email like '%gmail.com'")
    //List<Spitter> findAllByGmail (); // if name is too big "gmail" method.

}