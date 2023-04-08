package com.example.isimmbackendv1.semestre;

import com.example.isimmbackendv1.semestre.Semestre;
import com.example.isimmbackendv1.semestre.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/semestre")
public class SemestreController {
    private final SemestreService semestreService;

    @Autowired
    public SemestreController(SemestreService semestreService){
        this.semestreService=semestreService;
    }

    @GetMapping(path="{semestreId}")
    public Semestre getSemestre(@PathVariable("semestreId") Long semestreId){
        return semestreService.getSemestre(semestreId);

    }
    @GetMapping
    public List<Semestre> getSemestres(){
        return semestreService.getSemestres();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addSemestre(@RequestBody Semestre semestre){
        semestreService.addSemestre(semestre);
    }

    @DeleteMapping(path="{semestreId}")
    public void deleteSemestre(@PathVariable("semestreId") Long semestreId){
        semestreService.deleteSemestre(semestreId);
    }
}
