package com.example.isimmbackendv1.section;

import com.example.isimmbackendv1.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section,Long> {
    @Query("SELECT s FROM Section s where  s.name=?1")
    Optional<Section> chargeFindSectionByName(String name);
}