package com.example.isimmbackendv1.semestre;


import com.example.isimmbackendv1.matiere.Matiere;
import com.example.isimmbackendv1.unite.Unite;
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
public class Semestre implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long semestreId;

    @Column(length = 200)
    private String name;

    @OneToMany
    private List<Unite> unites;

    public Semestre(String name, List<Unite> unites) {
        this.name = name;
        this.unites = unites;
    }
}
