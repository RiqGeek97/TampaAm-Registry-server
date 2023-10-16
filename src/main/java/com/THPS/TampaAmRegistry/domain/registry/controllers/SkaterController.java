package com.THPS.TampaAmRegistry.domain.registry.controllers;

import com.THPS.TampaAmRegistry.domain.registry.models.Skater;
import com.THPS.TampaAmRegistry.domain.registry.services.SkaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skaters")
public class SkaterController {
    private SkaterService skaterService;

    @Autowired
    public SkaterController(SkaterService skaterService){
        this.skaterService = skaterService;
    }

    @GetMapping
    public ResponseEntity<List<Skater>> getAll(){
        List<Skater> skater = skaterService.getAll();
        return new ResponseEntity<>(skater, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Skater> create(@RequestBody Skater skater){
        skater = skaterService.create(skater);
        return new ResponseEntity<>(skater, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Skater> getById(@PathVariable("id") Long id){
        Skater skater = skaterService.getById(id);
        return new ResponseEntity<>(skater, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Skater> getByTeam(@RequestParam String team){
        Skater skater = skaterService.getByTeam(team);
        return new ResponseEntity<>(skater, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Skater> update(@PathVariable("id") Long id, @RequestBody Skater skaterDetail){
        skaterDetail = skaterService.update(id, skaterDetail);
        return new ResponseEntity<>(skaterDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        skaterService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
