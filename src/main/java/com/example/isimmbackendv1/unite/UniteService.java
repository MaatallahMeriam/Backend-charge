package com.example.isimmbackendv1.unite;

import com.example.isimmbackendv1.unite.Unite;
import com.example.isimmbackendv1.unite.UniteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniteService {

    private final UniteRepository uniteRepository;

    public Unite getUnite(Long uniteId) {
        Unite unite=uniteRepository.findById(uniteId).orElseThrow(()->new IllegalStateException(("Unite does not exist")));
        return unite;
    }

    public List<Unite> getUnites() {
        return uniteRepository.findAll();
    }

    public void addUnite(Unite unite) {
        Optional<Unite> uniteOptional= uniteRepository.chargeFindUniteByName(unite.getName());
        if(uniteOptional.isPresent()){
            throw new IllegalStateException("Unite Exists");
        }
        uniteRepository.save(unite);
    }


    public void deleteUnite(Long uniteId) {
        boolean exists=uniteRepository.existsById(uniteId);
        if(!exists){
            throw new IllegalStateException("Unite with id"+uniteId+" does not exists");
        }
        uniteRepository.deleteById(uniteId);

    }
}