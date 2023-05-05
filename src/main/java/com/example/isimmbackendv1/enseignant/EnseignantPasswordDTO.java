package com.example.isimmbackendv1.enseignant;

import lombok.Data;


@Data
public class EnseignantPasswordDTO {
    private Long enseignantId;
    private String oldPass;
    private String newPass;
}

