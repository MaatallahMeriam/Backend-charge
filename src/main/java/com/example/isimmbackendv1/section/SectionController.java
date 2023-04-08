package com.example.isimmbackendv1.section;

import com.example.isimmbackendv1.section.Section;
import com.example.isimmbackendv1.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/isimm/distributionCharge/section")
public class SectionController {
    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService){
        this.sectionService=sectionService;
    }

    @GetMapping(path="{sectionId}")
    public Section getSection(@PathVariable("sectionId") Long sectionId){
        return sectionService.getSection(sectionId);

    }
    @GetMapping(path="type/{sectionName}")
    public Section getSectionName(@PathVariable("sectionName") String sectionName){
        return sectionService.getSectionName(sectionName);

    }
    @GetMapping
    public List<Section> getSections(){
        return sectionService.getSections();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addSection(@RequestBody Section section){
        sectionService.addSection(section);
    }

    @DeleteMapping(path="{sectionId}")
    public void deleteSection(@PathVariable("sectionId") Long sectionId){
        sectionService.deleteSection(sectionId);
    }
}


