package com.example.isimmbackendv1.voeux;

import com.example.isimmbackendv1.voeux.Voeux;
import com.example.isimmbackendv1.voeux.VoeuxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoeuxService {

    private final VoeuxRepository voeuxRepository;

    public Voeux getVoeux(Long voeuxId) {
        Voeux voeux=voeuxRepository.findById(voeuxId).orElseThrow(()->new IllegalStateException(("Voeux does not exist")));
        return voeux;
    }

    public List<Voeux> getVoeuxs() {
        return voeuxRepository.findAll();
    }

    public void addVoeux(Voeux voeux) {
        Optional<Voeux> voeuxOptional= voeuxRepository.chargeFindVoeuxByName(voeux.getName());
        if(voeuxOptional.isPresent()){
            throw new IllegalStateException("Voeux Exists");
        }
        voeuxRepository.save(voeux);
    }


    public void deleteVoeux(Long voeuxId) {
        boolean exists=voeuxRepository.existsById(voeuxId);
        if(!exists){
            throw new IllegalStateException("Voeux with id"+voeuxId+" does not exists");
        }
        voeuxRepository.deleteById(voeuxId);

    }
}


