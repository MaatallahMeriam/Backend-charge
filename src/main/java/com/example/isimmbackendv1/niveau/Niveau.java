package com.example.isimmbackendv1.niveau;

import com.example.isimmbackendv1.semestre.Semestre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Niveau implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long niveauId;

    @Column(length = 200)
    private String name;

    @OneToMany
    private List<Semestre> semestres;

    public Niveau(String name, List<Semestre> semestres) {
        this.name = name;
        this.semestres = semestres;
    }
}
