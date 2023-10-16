package com.THPS.TampaAmRegistry.domain.registry.services;

import com.THPS.TampaAmRegistry.domain.core.exceptions.ResourceCreationException;
import com.THPS.TampaAmRegistry.domain.core.exceptions.ResourceNotFoundException;
import com.THPS.TampaAmRegistry.domain.registry.models.Skater;
import com.THPS.TampaAmRegistry.domain.registry.repos.SkaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkaterServiceImpl implements SkaterService{
    private SkaterRepository skaterRepository;

    @Autowired
    public SkaterServiceImpl(SkaterRepository skaterRepository) {
        this.skaterRepository = skaterRepository;
    }
    @Override
    public Skater create(Skater skater) throws ResourceCreationException {
        Optional<Skater> optional = skaterRepository.findByTeam(skater.getTeam());
        if(optional.isPresent())
            throw new ResourceCreationException("Skater: " + skater.getFirstName() + " " + skater.getLastName() + " " + skater.getTeam() + " already registered!");
        skater = skaterRepository.save(skater);
        return skater;
    }

    @Override
    public Skater getById(Long id) throws ResourceNotFoundException {
        Skater skater = skaterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Team found with this ID: " + id));
        return skater;
    }

    @Override
    public Skater getByTeam(String team) throws ResourceNotFoundException {
        Skater skater = skaterRepository.findByTeam(team)
                .orElseThrow(() -> new ResourceNotFoundException("No Team named: " + team));
        return skater;
    }

    @Override
    public List<Skater> getAll() {
        return skaterRepository.findAll();
    }

    @Override
    public Skater update(Long id, Skater skaterDetail) throws ResourceNotFoundException {
        Skater skater = getById(id);
        skater.setFirstName(skaterDetail.getFirstName());
        skater.setLastName(skaterDetail.getLastName());
        skater.setTeam(skaterDetail.getTeam());
        skater = skaterRepository.save(skater);
        return skater;
    }

    @Override
    public void delete(Long id) {
        Skater skater = getById(id);
        skaterRepository.delete(skater);
    }
}
