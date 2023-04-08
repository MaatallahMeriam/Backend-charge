package com.example.isimmbackendv1.regime;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegimeService {

    private final RegimeRepository regimeRepository;

    public Regime getRegime(Long regimeId) {
        Regime regime=regimeRepository.findById(regimeId).orElseThrow(()->new IllegalStateException(("Regime does not exist")));
        return regime;
    }

    public List<Regime> getRegimes() {
        return regimeRepository.findAll();
    }

    public void addRegime(Regime regime) {
        Optional<Regime> regimeOptional= regimeRepository.chargeFindRegimeByName(regime.getName());
        if(regimeOptional.isPresent()){
            throw new IllegalStateException("Regime Exists");
        }
        regimeRepository.save(regime);
    }


    public void deleteRegime(Long regimeId) {
        boolean exists=regimeRepository.existsById(regimeId);
        if(!exists){
            throw new IllegalStateException("Regime with id"+regimeId+" does not exists");
        }
        regimeRepository.deleteById(regimeId);

    }
}
