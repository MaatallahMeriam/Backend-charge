package com.example.isimmbackendv1.voeux;

import com.example.isimmbackendv1.voeux.Voeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VoeuxRepository extends JpaRepository<Voeux,Long> {
    @Query("SELECT s FROM Voeux s where  s.name=?1")
    Optional<Voeux> chargeFindVoeuxByName(String name);
}