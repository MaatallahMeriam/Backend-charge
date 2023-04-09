package com.example.isimmbackendv1.enseignant_voeux;

import com.example.isimmbackendv1.enseignant.Enseignant;
import com.example.isimmbackendv1.matiere.Matiere;
import com.example.isimmbackendv1.voeux.Voeux;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantVoeux implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long enseignantVoeuxId;

    private String type;
    @OneToOne
    private Voeux voeux;

    @OneToOne
    private Enseignant enseignant;

    @OneToOne
    private Matiere matiere;



    public EnseignantVoeux(Voeux voeux, Enseignant enseignant, Matiere matiere,String type) {
        this.voeux = voeux;
        this.enseignant = enseignant;
        this.matiere = matiere;
        this.type=type;
    }
}
