package com.example.WeSport.repository;


import com.example.WeSport.models.ERencontre;
import com.example.WeSport.models.Rencontre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RencontreRepository extends JpaRepository<Rencontre, Long> {

    List<Rencontre> findRencontreBySport(ERencontre sport);
    Optional<Rencontre> findRencontreById(Long id);
    List<Rencontre> findRencontresByOwner(Long id);

}
