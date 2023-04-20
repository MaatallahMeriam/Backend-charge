package com.example.isimmbackendv1.enseignant_matiere;

import com.example.isimmbackendv1.enseignant.Enseignant;
import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnseignantMatiereRepository extends JpaRepository<EnseignantMatiere,Long> {
    @Query("SELECT s FROM EnseignantMatiere s where  s.matiere.matiereId=?1")
    List<EnseignantMatiere> findEnseignantMatiereByMatiere(Long matiereId);
}