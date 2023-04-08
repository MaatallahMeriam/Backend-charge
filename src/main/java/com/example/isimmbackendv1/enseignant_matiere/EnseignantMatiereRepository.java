package com.example.isimmbackendv1.enseignant_matiere;

import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnseignantMatiereRepository extends JpaRepository<EnseignantMatiere,Long> {

}