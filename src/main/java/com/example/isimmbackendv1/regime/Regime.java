package com.example.isimmbackendv1.regime;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Regime implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long regimeId;

    @Column(length = 200)
    private String name;

    public Regime() {
    }

    public Regime(Long regimeId, String name) {
        this.regimeId = regimeId;
        this.name = name;
    }

    public Regime(String name) {
        this.name = name;
    }
}
