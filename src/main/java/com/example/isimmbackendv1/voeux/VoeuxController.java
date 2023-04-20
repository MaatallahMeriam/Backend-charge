package com.example.isimmbackendv1.voeux;

import com.example.isimmbackendv1.voeux.Voeux;
import com.example.isimmbackendv1.voeux.VoeuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/voeux")
public class VoeuxController {
    private final VoeuxService voeuxService;

    @Autowired
    public VoeuxController(VoeuxService voeuxService){
        this.voeuxService=voeuxService;
    }

    @GetMapping(path="{voeuxId}")
    public Voeux getVoeux(@PathVariable("voeuxId") Long voeuxId){
        return voeuxService.getVoeux(voeuxId);

    }
    @GetMapping
    public List<Voeux> getVoeuxs(){
        return voeuxService.getVoeuxs();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public Voeux addVoeux(@RequestBody Voeux voeux){
        return voeuxService.addVoeux(voeux);
    }

    @DeleteMapping(path="{voeuxId}")
    public void deleteVoeux(@PathVariable("voeuxId") Long voeuxId){
        voeuxService.deleteVoeux(voeuxId);
    }
}


