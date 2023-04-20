package com.example.isimmbackendv1.matiere;

import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiere;
import com.example.isimmbackendv1.enseignant_voeux.EnseignantVoeux;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class MatiereDTO {
    private Long matiereId;
    private String name;
    private int code;
    private List<EnseignantMatiere> enseignantMatieres;
    private List<EnseignantVoeux> enseignantVoeux;
}
