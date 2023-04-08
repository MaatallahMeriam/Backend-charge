package com.example.isimmbackendv1.matiere;

import com.example.isimmbackendv1.regime.Regime;
import com.example.isimmbackendv1.regime.RegimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class MatiereService {

    private final MatiereRepository matiereRepository;

    public Matiere getMatiere(Long matiereId) {
        Matiere matiere=matiereRepository.findById(matiereId).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));
        return matiere;
    }

    public List<Matiere> getMatieres() {
        return matiereRepository.findAll();
    }

    public void addMatiere(Matiere matiere) {
        Optional<Matiere> matiereOptional= matiereRepository.chargeFindMatiereByName(matiere.getName());
        if(matiereOptional.isPresent()){
            throw new IllegalStateException("Matiere Exists");
        }
        matiereRepository.save(matiere);
    }


    public void deleteMatiere(Long matiereId) {
        boolean exists=matiereRepository.existsById(matiereId);
        if(!exists){
            throw new IllegalStateException("Matiere with id"+matiereId+" does not exists");
        }
        matiereRepository.deleteById(matiereId);

    }
}
