package com.example.isimmbackendv1.diplome;

import com.example.isimmbackendv1.diplome.Diplome;
import com.example.isimmbackendv1.diplome.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/diplome")
public class DiplomeController {
    private final DiplomeService diplomeService;

    @Autowired
    public DiplomeController(DiplomeService diplomeService){
        this.diplomeService=diplomeService;
    }

    @GetMapping(path="{diplomeId}")
    public Diplome getDiplome(@PathVariable("diplomeId") Long diplomeId){
        return diplomeService.getDiplome(diplomeId);

    }
    @GetMapping
    public List<Diplome> getDiplomes(){
        return diplomeService.getDiplomes();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addDiplome(@RequestBody Diplome diplome){
        diplomeService.addDiplome(diplome);
    }

    @DeleteMapping(path="{diplomeId}")
    public void deleteDiplome(@PathVariable("diplomeId") Long diplomeId){
        diplomeService.deleteDiplome(diplomeId);
    }
}

