package com.example.isimmbackendv1.enseignant_matiere;

import com.example.isimmbackendv1.enseignant.Enseignant;
import com.example.isimmbackendv1.matiere.Matiere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantMatiere implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long enseignantMatiereId;


    @OneToOne
    private Matiere matiere;

    @OneToOne
    private Enseignant enseignant;

    private String type;

    public EnseignantMatiere(Matiere matiere, Enseignant enseignant, String type) {
        this.matiere = matiere;
        this.enseignant = enseignant;
        this.type = type;
    }


}
