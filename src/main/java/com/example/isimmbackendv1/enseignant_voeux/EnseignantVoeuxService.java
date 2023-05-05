package com.example.isimmbackendv1.enseignant_voeux;

import com.example.isimmbackendv1.enseignant_voeux.EnseignantVoeux;
import com.example.isimmbackendv1.enseignant_voeux.EnseignantVoeuxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnseignantVoeuxService {

    private final EnseignantVoeuxRepository enseignantVoeuxRepository;

    public EnseignantVoeux getEnseignantVoeux(Long enseignantVoeuxId) {
        EnseignantVoeux enseignantVoeux=enseignantVoeuxRepository.findById(enseignantVoeuxId).orElseThrow(()->new IllegalStateException(("EnseignantVoeux does not exist")));
        return enseignantVoeux;
    }

    public List<EnseignantVoeux> getEnseignantVoeuxs() {
        return enseignantVoeuxRepository.findAll();
    }

    public void addEnseignantVoeux(EnseignantVoeux enseignantVoeux) {
        /*Optional<EnseignantVoeux> enseignantVoeuxOptional= enseignantVoeuxRepository.chargeFindEnseignantVoeuxByName(enseignantVoeux.getName());
        if(enseignantVoeuxOptional.isPresent()){
            throw new IllegalStateException("EnseignantVoeux Exists");
        }*/
        enseignantVoeuxRepository.save(enseignantVoeux);
    }

    public List<EnseignantVoeux> getEnseignantVoeuxByEnseignantId( Long enseignantId, Long matiereId,  String matiereType)
    {
        return enseignantVoeuxRepository.findEnseignantVoeuxByEnseignantMatiereType(enseignantId,matiereId,matiereType);
    }

    public void deleteEnseignantVoeux(Long enseignantVoeuxId) {
        boolean exists=enseignantVoeuxRepository.existsById(enseignantVoeuxId);
        if(!exists){
            throw new IllegalStateException("EnseignantVoeux with id"+enseignantVoeuxId+" does not exists");
        }
        enseignantVoeuxRepository.deleteById(enseignantVoeuxId);

    }
}


