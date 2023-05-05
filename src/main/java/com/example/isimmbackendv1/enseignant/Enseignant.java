package com.example.isimmbackendv1.enseignant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enseignant implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long enseignantId;

    public Long getEnseignantId() {
        return enseignantId;
    }

    @Column
    private float NombreHeures;

    @Column
    private Grade gradeEnseignant ;

    @Column(length = 100)
    private String cin;
    @Column(length = 100)
    private String nom;
    @Column(length = 100)
    private String prenom;

    @Column
    private Date naissance;

    @Enumerated(EnumType.STRING)
    @Column
    private Sexe sexe;

    @Column(length = 500)
    private String adresse ;
    @Column(length = 100)
    private String password;
    @Column(length = 100)
    private String email;
    @Column(length = 100)
    private String telephone;
    @Column
    private int age;

    public Enseignant( float nombreHeures, Grade gradeEnseignant, String cin, String nom, String prenom, Date naissance, Sexe sexe, String adresse, String password, String email, String telephone, int age) {

        NombreHeures = nombreHeures;
        this.gradeEnseignant = gradeEnseignant;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
    }
}
