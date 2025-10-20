package com.myking.serverapp.region;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository){
        this.regionRepository = regionRepository;
    }

    public List<Region> getAll(){
        return regionRepository.findAll();
    }

    public Optional<Region> getId(Integer id){
        return regionRepository.findById(id);
    }

    public Region create(Region region){
        return regionRepository.save(region);
    }

    public Region update(Integer id, Region update){
        return regionRepository.findById(id)
            .map(region -> {
                region.setName(update.getName());
                return regionRepository.save(region);
            }) .orElseThrow(() -> new RuntimeException("Region Not Found "));
    }

    public String delete (Integer id){
            regionRepository.deleteById(id);
            return "Data dengan ID " + id + " berhasil dihapus.";
    }
    


}
