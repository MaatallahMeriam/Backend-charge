package com.example.isimmbackendv1.matiere;

import com.example.isimmbackendv1.regime.Regime;
import com.example.isimmbackendv1.regime.RegimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/matiere")
public class MatiereController {
    private final MatiereService matiereService;

    @Autowired
    public MatiereController(MatiereService matiereService){
        this.matiereService=matiereService;
    }

    @GetMapping(path="{matiereId}")
    public Matiere getMatiere(@PathVariable("matiereId") Long matiereId){
        return matiereService.getMatiere(matiereId);

    }
    @GetMapping
    public List<Matiere> getMatieres(){
        return matiereService.getMatieres();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addMatiere(@RequestBody Matiere matiere){
        matiereService.addMatiere(matiere);
    }

    @DeleteMapping(path="{matiereId}")
    public void deleteMatiere(@PathVariable("matiereId") Long matiereId){
        matiereService.deleteMatiere(matiereId);
    }
}
