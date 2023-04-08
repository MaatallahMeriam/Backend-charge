package com.example.isimmbackendv1.niveau;

import com.example.isimmbackendv1.niveau.Niveau;
import com.example.isimmbackendv1.niveau.NiveauRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NiveauService {

    private final NiveauRepository niveauRepository;

    public Niveau getNiveau(Long niveauId) {
        Niveau niveau=niveauRepository.findById(niveauId).orElseThrow(()->new IllegalStateException(("Niveau does not exist")));
        return niveau;
    }

    public List<Niveau> getNiveaus() {
        return niveauRepository.findAll();
    }

    public void addNiveau(Niveau niveau) {
        Optional<Niveau> niveauOptional= niveauRepository.chargeFindNiveauByName(niveau.getName());
        if(niveauOptional.isPresent()){
            throw new IllegalStateException("Niveau Exists");
        }
        niveauRepository.save(niveau);
    }


    public void deleteNiveau(Long niveauId) {
        boolean exists=niveauRepository.existsById(niveauId);
        if(!exists){
            throw new IllegalStateException("Niveau with id"+niveauId+" does not exists");
        }
        niveauRepository.deleteById(niveauId);

    }
}

