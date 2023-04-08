package com.example.isimmbackendv1.section;

import com.example.isimmbackendv1.section.Section;
import com.example.isimmbackendv1.section.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SectionService {

    private final SectionRepository sectionRepository;

    public Section getSection(Long sectionId) {
        Section section=sectionRepository.findById(sectionId).orElseThrow(()->new IllegalStateException(("Section does not exist")));
        return section;
    }

    public Section getSectionName(String sectionName) {
        Section section=sectionRepository.chargeFindSectionByName(sectionName).orElseThrow(()->new IllegalStateException(("Section does not exist")));
        return section;
    }

    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    public void addSection(Section section) {
        Optional<Section> sectionOptional= sectionRepository.chargeFindSectionByName(section.getName());
        if(sectionOptional.isPresent()){
            throw new IllegalStateException("Section Exists");
        }
        sectionRepository.save(section);
    }


    public void deleteSection(Long sectionId) {
        boolean exists=sectionRepository.existsById(sectionId);
        if(!exists){
            throw new IllegalStateException("Section with id"+sectionId+" does not exists");
        }
        sectionRepository.deleteById(sectionId);

    }
}


