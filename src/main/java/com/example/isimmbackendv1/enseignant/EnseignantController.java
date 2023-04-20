package com.example.isimmbackendv1.enseignant;

import com.example.isimmbackendv1.enseignant.Enseignant;
import com.example.isimmbackendv1.enseignant.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    @GetMapping(path = "/getEnseignantByName")
    public Optional<Enseignant> getEnseignantByName(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom) {
        return enseignantService.getEnseignantByName(nom, prenom);
    }

    @GetMapping(path="{enseignantName}")
    public Enseignant getEnseignantByName(@PathVariable("enseignantName") String enseignantName){
        return enseignantService.getEnseignantByName(enseignantName);

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


