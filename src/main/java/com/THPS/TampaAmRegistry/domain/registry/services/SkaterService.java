package com.THPS.TampaAmRegistry.domain.registry.services;

import com.THPS.TampaAmRegistry.domain.core.exceptions.ResourceCreationException;
import com.THPS.TampaAmRegistry.domain.core.exceptions.ResourceNotFoundException;
import com.THPS.TampaAmRegistry.domain.registry.models.Skater;

import java.util.List;

public interface SkaterService {
    Skater create(Skater skater) throws ResourceCreationException;
    Skater getById(Long id) throws ResourceNotFoundException;
    Skater getByTeam(String team) throws ResourceNotFoundException;
    List<Skater> getAll();
    Skater update(Long id, Skater skaterDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
