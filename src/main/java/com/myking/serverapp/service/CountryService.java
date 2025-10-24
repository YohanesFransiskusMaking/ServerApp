package com.myking.serverapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.myking.serverapp.dto.request.CountryRequest;
import com.myking.serverapp.dto.response.CountryResponse;
import com.myking.serverapp.model.Country;
import com.myking.serverapp.model.Region;
import com.myking.serverapp.repository.CountryRepository;
import com.myking.serverapp.repository.RegionRepository;



@Service
public class CountryService {
    private CountryRepository countryRepository;
    private RegionRepository regionRepository;

    CountryService(CountryRepository countryRepository, RegionRepository regionRepository){
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
    }

    public List<CountryResponse> findAll(){
       List <Country> countrys = countryRepository.findAll();
        List<CountryResponse> responses = new ArrayList<>();
       for(Country c : countrys){
        CountryResponse dto = new CountryResponse();

        dto.setCountryName(c.getCountryName());
        dto.setCountryCode(c.getCountryCode());
        dto.setRegionName(c.getRegion().getRegionName());
        responses.add(dto);
       }

        return responses;
    }

    public CountryResponse findById(Integer id){

        Country country = countryRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));
        
        CountryResponse response = new CountryResponse();
        response.setCountryName(country.getCountryName());
        response.setCountryCode(country.getCountryCode());
        response.setRegionName(country.getRegion().getRegionName());
        
        return response;
    }

    public CountryResponse create(CountryRequest countryRequest){
       
        Country country = new Country();

        country.setCountryName(countryRequest.getCountryName());
        country.setCountryCode(countryRequest.getCountryCode());

        Region region = regionRepository.findById(countryRequest.getRegionId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));
        country.setRegion(region);
        
        countryRepository.save(country);

        CountryResponse response = new CountryResponse();
        response.setCountryName(country.getCountryName());
        response.setCountryCode(country.getCountryCode());
        response.setRegionName(country.getRegion().getRegionName());

        return response;
    }

    public CountryResponse update(Integer id, CountryRequest countryRequest){
        Country country = countryRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));

    
        country.setCountryName(countryRequest.getCountryName());
        country.setCountryCode(countryRequest.getCountryCode());
        
        Region region = regionRepository.findById(countryRequest.getRegionId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));
        country.setRegion(region);

        countryRepository.save(country);

        CountryResponse response = new CountryResponse();

        response.setCountryName(country.getCountryName());
        response.setCountryCode(country.getCountryCode());
        response.setRegionName(country.getRegion().getRegionName());
        return response;
    }
 
    public CountryResponse delete(Integer id){

        Country hapus = countryRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan"));

        countryRepository.delete(hapus);

        CountryResponse response = new CountryResponse();
        response.setCountryName(hapus.getCountryName());
        response.setCountryCode(hapus.getCountryCode());
        response.setRegionName(hapus.getRegion().getRegionName());

        return response;
    }


}
