package com.example.isimmbackendv1.voeux;

import com.example.isimmbackendv1.matiere.Matiere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voeux implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long voeuxId;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String message;



    public Voeux(String name, String message) {
        this.name = name;
        this.message = message;
    }
}