package com.example.isimmbackendv1.enseignant_matiere;

import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiere;
import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiereRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnseignantMatiereService {

    private final EnseignantMatiereRepository enseignantMatiereRepository;

    public EnseignantMatiere getEnseignantMatiere(Long enseignantMatiereId) {
        EnseignantMatiere enseignantMatiere=enseignantMatiereRepository.findById(enseignantMatiereId).orElseThrow(()->new IllegalStateException(("EnseignantMatiere does not exist")));
        return enseignantMatiere;
    }

    public List<EnseignantMatiere> getEnseignantMatieres() {
        return enseignantMatiereRepository.findAll();
    }

    public void addEnseignantMatiere(EnseignantMatiere enseignantMatiere) {
        /*Optional<EnseignantMatiere> enseignantMatiereOptional= enseignantMatiereRepository.chargeFindEnseignantMatiereByName(enseignantMatiere.getName());
        if(enseignantMatiereOptional.isPresent()){
            throw new IllegalStateException("EnseignantMatiere Exists");
        }*/
        enseignantMatiereRepository.save(enseignantMatiere);
    }


    public void deleteEnseignantMatiere(Long enseignantMatiereId) {
        boolean exists=enseignantMatiereRepository.existsById(enseignantMatiereId);
        if(!exists){
            throw new IllegalStateException("EnseignantMatiere with id"+enseignantMatiereId+" does not exists");
        }
        enseignantMatiereRepository.deleteById(enseignantMatiereId);

    }
}


