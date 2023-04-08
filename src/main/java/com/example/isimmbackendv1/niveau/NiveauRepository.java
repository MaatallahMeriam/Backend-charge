package com.example.isimmbackendv1.niveau;

import com.example.isimmbackendv1.semestre.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
    @Query("SELECT s FROM Niveau s where  s.name=?1")
    Optional<Niveau> chargeFindNiveauByName(String name);
}
