package com.example.isimmbackendv1.matiere;

import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiereRepository;
import com.example.isimmbackendv1.enseignant_voeux.EnseignantVoeuxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MatiereService {

    private final MatiereRepository matiereRepository;
    private final EnseignantMatiereRepository enseignantMatiereRepository;
    private final EnseignantVoeuxRepository enseignantVoeuxRepository;

    public MatiereDTO getMatiere(Long matiereId) {
        Matiere matiere=matiereRepository.findById(matiereId).orElseThrow(()->new IllegalStateException(("Matiere does not exist")));

        return convertMatiereToDto(matiere);
    }

    public List<Matiere> getMatieres() {
        return matiereRepository.findAll();
    }

    private MatiereDTO convertMatiereToDto(Matiere matiere)
    {
        MatiereDTO matiereDTO = new MatiereDTO();

        matiereDTO.setMatiereId(matiere.getMatiereId());
        matiereDTO.setName(matiere.getName());
        matiereDTO.setCode(matiere.getCode());
        matiereDTO.setEnseignantMatieres(enseignantMatiereRepository.findEnseignantMatiereByMatiere(matiere.getMatiereId()));
        matiereDTO.setEnseignantVoeux(enseignantVoeuxRepository.findEnseignantVoeuxByMatiere(matiere.getMatiereId()));

        return matiereDTO;
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
