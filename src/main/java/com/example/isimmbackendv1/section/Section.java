package com.example.isimmbackendv1.section;

import com.example.isimmbackendv1.niveau.Niveau;
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
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long sectionId;

    @Column(length = 200)
    private String name;

    @OneToMany
    private List<Niveau> niveaux;

    public Section(String name, List<Niveau> niveaux) {
        this.name = name;
        this.niveaux = niveaux;
    }
}
