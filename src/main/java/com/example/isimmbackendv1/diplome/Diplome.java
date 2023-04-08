package com.example.isimmbackendv1.diplome;

import com.example.isimmbackendv1.section.Section;
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
public class Diplome  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long diplomeId;

    @Column(length = 200)
    private String name;

    @OneToMany
    private List<Section> sections;

    public Diplome(String name, List<Section> sections) {
        this.name = name;
        this.sections = sections;
    }
}
