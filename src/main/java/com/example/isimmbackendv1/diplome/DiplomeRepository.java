package com.example.isimmbackendv1.diplome;

import com.example.isimmbackendv1.diplome.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DiplomeRepository extends JpaRepository<Diplome,Long> {
    @Query("SELECT s FROM Diplome s where  s.name=?1")
    Optional<Diplome> chargeFindDiplomeByName(String name);
}