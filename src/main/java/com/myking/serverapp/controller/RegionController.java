package com.myking.serverapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myking.serverapp.model.Region;
import com.myking.serverapp.service.RegionService;

@RestController
@RequestMapping("/api")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService){
        this.regionService = regionService;
    }

    @GetMapping
    public List<Region> findAll(){
        return regionService.findAll();
    }
    @GetMapping("/{id}")
    public Region findById(@PathVariable Integer id){
        return regionService.findById(id);
    }

    @PostMapping
    public Region create(@RequestBody Region region){
        return regionService.create(region);
    }
    @PutMapping("/{id}")
    public Region update(@RequestBody Region region, @PathVariable Integer id){
        return regionService.update(id, region);
    }
    @DeleteMapping("/{id}")
    public Region delete(@PathVariable Integer id){
        return regionService.hapus(id);
    }




}
