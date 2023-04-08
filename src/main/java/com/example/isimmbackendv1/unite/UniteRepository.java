package com.example.isimmbackendv1.unite;

import com.example.isimmbackendv1.matiere.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UniteRepository extends JpaRepository<Unite,Long> {

    @Query("SELECT s FROM Unite s where  s.name=?1")
    Optional<Unite> chargeFindUniteByName(String name);
}
