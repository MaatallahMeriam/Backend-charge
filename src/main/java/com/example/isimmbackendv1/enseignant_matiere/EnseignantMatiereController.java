package com.example.isimmbackendv1.enseignant_matiere;

import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiere;
import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/enseignantMatiere")
public class EnseignantMatiereController {
    private final EnseignantMatiereService enseignantMatiereService;

    @Autowired
    public EnseignantMatiereController(EnseignantMatiereService enseignantMatiereService){
        this.enseignantMatiereService=enseignantMatiereService;
    }

    @GetMapping(path="{enseignantMatiereId}")
    public EnseignantMatiere getEnseignantMatiere(@PathVariable("enseignantMatiereId") Long enseignantMatiereId){
        return enseignantMatiereService.getEnseignantMatiere(enseignantMatiereId);

    }
    @GetMapping
    public List<EnseignantMatiere> getEnseignantMatieres(){
        return enseignantMatiereService.getEnseignantMatieres();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addEnseignantMatiere(@RequestBody EnseignantMatiere enseignantMatiere){
        enseignantMatiereService.addEnseignantMatiere(enseignantMatiere);
    }

    @PutMapping(consumes = "application/json;charset=UTF-8",path = "/updateEnseignantMatiere")
    public void updateEnseignantMatiere(@RequestParam("matiereId") Long matiereId,@RequestParam("enseignantId") Long enseignantId,@RequestParam("type") String type){
        System.out.println(matiereId);
        System.out.println(enseignantId);
        System.out.println(type);
        enseignantMatiereService.updateEnseignantMatiere(matiereId,enseignantId,type);

    }

    @DeleteMapping(path="{enseignantMatiereId}")
    public void deleteEnseignantMatiere(@PathVariable("enseignantMatiereId") Long enseignantMatiereId){
        enseignantMatiereService.deleteEnseignantMatiere(enseignantMatiereId);
    }
}


