package com.example.isimmbackendv1.semestre;

import com.example.isimmbackendv1.semestre.Semestre;
import com.example.isimmbackendv1.semestre.SemestreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public Semestre getSemestre(Long semestreId) {
        Semestre semestre=semestreRepository.findById(semestreId).orElseThrow(()->new IllegalStateException(("Semestre does not exist")));
        return semestre;
    }

    public Semestre getSemestreName(String semestreName) {
        Semestre semestre=semestreRepository.chargeFindSemestreByName(semestreName).orElseThrow(()->new IllegalStateException(("Semestre does not exist")));
        return semestre;
    }

    public List<Semestre> getSemestres() {
        return semestreRepository.findAll();
    }

    public void addSemestre(Semestre semestre) {
        Optional<Semestre> semestreOptional= semestreRepository.chargeFindSemestreByName(semestre.getName());
        if(semestreOptional.isPresent()){
            throw new IllegalStateException("Semestre Exists");
        }
        semestreRepository.save(semestre);
    }


    public void deleteSemestre(Long semestreId) {
        boolean exists=semestreRepository.existsById(semestreId);
        if(!exists){
            throw new IllegalStateException("Semestre with id"+semestreId+" does not exists");
        }
        semestreRepository.deleteById(semestreId);

    }
}
