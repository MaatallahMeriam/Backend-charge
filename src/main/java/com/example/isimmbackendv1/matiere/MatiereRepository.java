package com.example.isimmbackendv1.matiere;

import com.example.isimmbackendv1.regime.Regime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MatiereRepository extends JpaRepository<Matiere,Long> {

    @Query("SELECT s FROM Matiere s where  s.name=?1")
    Optional<Matiere> chargeFindMatiereByName(String name);
}
