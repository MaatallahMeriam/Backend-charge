package com.example.isimmbackendv1.unite;

import com.example.isimmbackendv1.matiere.Matiere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long uniteId;

    @Column(length = 200)
    private String name;

    @Column
    private int  codeUnite ;

    @OneToMany
    private List<Matiere> matieres;

    public Unite(String name, int codeUnite, List<Matiere> matieres) {
        this.name = name;
        this.codeUnite = codeUnite;
        this.matieres = matieres;
    }
}
