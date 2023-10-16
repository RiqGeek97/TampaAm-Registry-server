package com.THPS.TampaAmRegistry.domain.registry.repos;

import com.THPS.TampaAmRegistry.domain.registry.models.Skater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkaterRepository extends JpaRepository<Skater, Long> {
    Optional<Skater> findByTeam(String Team);
}