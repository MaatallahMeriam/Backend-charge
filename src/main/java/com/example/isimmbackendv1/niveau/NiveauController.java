package com.example.isimmbackendv1.niveau;

import com.example.isimmbackendv1.niveau.Niveau;
import com.example.isimmbackendv1.niveau.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/niveau")
public class NiveauController {
    private final NiveauService niveauService;

    @Autowired
    public NiveauController(NiveauService niveauService){
        this.niveauService=niveauService;
    }

    @GetMapping(path="{niveauId}")
    public Niveau getNiveau(@PathVariable("niveauId") Long niveauId){
        return niveauService.getNiveau(niveauId);

    }
    @GetMapping
    public List<Niveau> getNiveaus(){
        return niveauService.getNiveaus();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addNiveau(@RequestBody Niveau niveau){
        niveauService.addNiveau(niveau);
    }

    @DeleteMapping(path="{niveauId}")
    public void deleteNiveau(@PathVariable("niveauId") Long niveauId){
        niveauService.deleteNiveau(niveauId);
    }
}

