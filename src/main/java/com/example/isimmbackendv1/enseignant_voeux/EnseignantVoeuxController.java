package com.example.isimmbackendv1.enseignant_voeux;

import com.example.isimmbackendv1.enseignant_matiere.EnseignantMatiere;
import com.example.isimmbackendv1.enseignant_voeux.EnseignantVoeux;
import com.example.isimmbackendv1.enseignant_voeux.EnseignantVoeuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/enseignantVoeux")
public class EnseignantVoeuxController {
    private final EnseignantVoeuxService enseignantVoeuxService;

    @Autowired
    public EnseignantVoeuxController(EnseignantVoeuxService enseignantVoeuxService){
        this.enseignantVoeuxService=enseignantVoeuxService;
    }

    @GetMapping(path="{enseignantVoeuxId}")
    public EnseignantVoeux getEnseignantVoeux(@PathVariable("enseignantVoeuxId") Long enseignantVoeuxId){
        return enseignantVoeuxService.getEnseignantVoeux(enseignantVoeuxId);

    }
    @GetMapping(path="/getEnseignantVoeuxByEnseignantId")
    public List<EnseignantVoeux> getEnseignantVoeuxByEnseignantId(@RequestParam("enseignantId") Long enseignantId,@RequestParam("matiereId") Long matiereId,@RequestParam("matiereType") String matiereType){
        return enseignantVoeuxService.getEnseignantVoeuxByEnseignantId(enseignantId,matiereId,matiereType);

    }
    @GetMapping
    public List<EnseignantVoeux> getEnseignantVoeuxs(){
        return enseignantVoeuxService.getEnseignantVoeuxs();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addEnseignantVoeux(@RequestBody EnseignantVoeux enseignantVoeux){
        enseignantVoeuxService.addEnseignantVoeux(enseignantVoeux);
    }

    @DeleteMapping(path="{enseignantVoeuxId}")
    public void deleteEnseignantVoeux(@PathVariable("enseignantVoeuxId") Long enseignantVoeuxId){
        enseignantVoeuxService.deleteEnseignantVoeux(enseignantVoeuxId);
    }
}


