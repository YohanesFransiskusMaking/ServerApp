package com.myking.serverapp.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.myking.serverapp.model.Region;
import com.myking.serverapp.repository.RegionRepository;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository){
        this.regionRepository = regionRepository;
    }

    public List<Region> findAll(){
        return regionRepository.findAll();
    }

    public Region findById(Integer id){
        return regionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Region tidak ditemukan"));
    }

    public Region create (Region region){
        return regionRepository.save(region);
    }
    public Region update(Integer id, Region region){
        Region update = findById(id);
        update.setRegionName(region.getRegionName());
        return regionRepository.save(update);
    }

    public Region hapus(Integer id){
        Region hapus = findById(id);
        regionRepository.delete(hapus);
       return hapus;        
    }

}
