package com.example.isimmbackendv1.enseignant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnseignantService {

    private final EnseignantRepository enseignantRepository;

    public Enseignant getEnseignant(Long enseignantId) {
        Enseignant enseignant=enseignantRepository.findById(enseignantId).orElseThrow(()->new IllegalStateException(("Enseignant does not exist")));
        return enseignant;
    }
    public Optional<Enseignant> getEnseignantByName(String nom, String prenom) {
        return enseignantRepository.findEnseignantByName(nom,prenom);

    }

    public List<Enseignant> getEnseignants() {
        return enseignantRepository.findAll();
    }

    public void addEnseignant(Enseignant enseignant) {
        Optional<Enseignant> enseignantOptional= enseignantRepository.chargeFindEnseignantByName(enseignant.getNom());
        if(enseignantOptional.isPresent()){
            throw new IllegalStateException("Enseignant Exists");
        }
        enseignantRepository.save(enseignant);
    }


    public void deleteEnseignant(Long enseignantId) {
        boolean exists=enseignantRepository.existsById(enseignantId);
        if(!exists){
            throw new IllegalStateException("Enseignant with id"+enseignantId+" does not exists");
        }
        enseignantRepository.deleteById(enseignantId);

    }
}


