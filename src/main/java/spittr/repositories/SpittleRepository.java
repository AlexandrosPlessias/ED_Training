package spittr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.domain.Spittle;

@Repository
public interface SpittleRepository extends JpaRepository<Spittle, Long> {

    @Modifying
    @Transactional
    @Query("update Spittle sp set sp.message = ?2 where sp.id = ?1")
    int setSpitterMessageById(Long id, String updatedMsg);

    //Spittle findById(long id);
    //Spittle findByOwnerId (Long id);

}
