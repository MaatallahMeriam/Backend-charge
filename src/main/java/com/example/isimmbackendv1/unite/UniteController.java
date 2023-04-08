package com.example.isimmbackendv1.unite;


import com.example.isimmbackendv1.unite.Unite;
import com.example.isimmbackendv1.unite.UniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/unite")
public class UniteController {
    private final UniteService uniteService;

    @Autowired
    public UniteController(UniteService uniteService){
        this.uniteService=uniteService;
    }

    @GetMapping(path="{uniteId}")
    public Unite getUnite(@PathVariable("uniteId") Long uniteId){
        return uniteService.getUnite(uniteId);

    }
    @GetMapping
    public List<Unite> getUnites(){
        return uniteService.getUnites();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addUnite(@RequestBody Unite unite){
        uniteService.addUnite(unite);
    }

    @DeleteMapping(path="{uniteId}")
    public void deleteUnite(@PathVariable("uniteId") Long uniteId){
        uniteService.deleteUnite(uniteId);
    }
}
