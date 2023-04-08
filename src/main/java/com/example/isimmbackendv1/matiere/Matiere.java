package com.example.isimmbackendv1.matiere;


import com.example.isimmbackendv1.regime.Regime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matiere implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long matiereId;

    @Column(length = 200)
    private String name;

    @Column
    private int code;

    @Column
    private float nbHCr;
    @Column
    private float nbHTd;
    @Column
    private float nbHTp;
    @Column
    private float nbHCri;
    @Column
    private float nbHNp;

    @ManyToOne
    private Regime regime;

    public Matiere(String name, int code, float nbHCr, float nbHTd, float nbHTp, float nbHCri, float nbHNp, Regime regime) {
        this.name = name;
        this.code = code;
        this.nbHCr = nbHCr;
        this.nbHTd = nbHTd;
        this.nbHTp = nbHTp;
        this.nbHCri = nbHCri;
        this.nbHNp = nbHNp;
        this.regime = regime;
    }
}
