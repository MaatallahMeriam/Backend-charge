package com.example.isimmbackendv1.regime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/regime")
public class RegimeController {

    private final RegimeService regimeService;

    @Autowired
    public RegimeController(RegimeService regimeService){
        this.regimeService=regimeService;
    }

    @GetMapping(path="{regimeId}")
    public Regime getRegime(@PathVariable("regimeId") Long regimeId){
        return regimeService.getRegime(regimeId);

    }
    @GetMapping
    public List<Regime> getRegimes(){
        return regimeService.getRegimes();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addRegime(@RequestBody Regime regime){
        regimeService.addRegime(regime);
    }

    @DeleteMapping(path="{regimeId}")
    public void deleteRegime(@PathVariable("regimeId") Long regimeId){
        regimeService.deleteRegime(regimeId);
    }
}
