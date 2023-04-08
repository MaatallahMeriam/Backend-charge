package com.example.isimmbackendv1.semestre;

import com.example.isimmbackendv1.unite.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {

    @Query("SELECT s FROM Semestre s where  s.name=?1")
    Optional<Semestre> chargeFindSemestreByName(String name);
}
