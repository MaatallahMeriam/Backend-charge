package com.example.isimmbackendv1.regime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegimeRepository extends JpaRepository<Regime,Long> {

    @Query("SELECT s FROM Regime s where  s.name=?1")
    Optional<Regime> chargeFindRegimeByName(String name);
}
