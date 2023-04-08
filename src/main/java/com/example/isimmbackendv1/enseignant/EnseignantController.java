package com.example.isimmbackendv1.enseignant;

import com.example.isimmbackendv1.enseignant.Enseignant;
import com.example.isimmbackendv1.enseignant.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/enseignant")
public class EnseignantController {
    private final EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService){
        this.enseignantService=enseignantService;
    }

    @GetMapping(path="{enseignantId}")
    public Enseignant getEnseignant(@PathVariable("enseignantId") Long enseignantId){
        return enseignantService.getEnseignant(enseignantId);

    }
    @GetMapping
    public List<Enseignant> getEnseignants(){
        return enseignantService.getEnseignants();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addEnseignant(@RequestBody Enseignant enseignant){
        enseignantService.addEnseignant(enseignant);
    }

    @DeleteMapping(path="{enseignantId}")
    public void deleteEnseignant(@PathVariable("enseignantId") Long enseignantId){
        enseignantService.deleteEnseignant(enseignantId);
    }
}


