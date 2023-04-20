package com.example.isimmbackendv1.enseignant_voeux;

import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiere;
import com.example.isimmbackendv1.enseignant_voeux.EnseignantVoeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnseignantVoeuxRepository extends JpaRepository<EnseignantVoeux,Long> {
    @Query("SELECT s FROM EnseignantVoeux s where  s.matiere.matiereId=?1")
    List<EnseignantVoeux> findEnseignantVoeuxByMatiere(Long matiereId);
}