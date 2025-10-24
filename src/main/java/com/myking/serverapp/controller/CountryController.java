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

import com.myking.serverapp.dto.request.CountryRequest;
import com.myking.serverapp.dto.response.CountryResponse;
import com.myking.serverapp.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryResponse> findAll(){
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public CountryResponse findById(@PathVariable Integer id){
        return countryService.findById(id);
    }

    @PostMapping
    public CountryResponse create(@RequestBody CountryRequest countryRequest){
            return countryService.create(countryRequest);
    }

    @PutMapping("/{id}")
    public CountryResponse update(@PathVariable Integer id, @RequestBody CountryRequest update){
        return countryService.update(id, update);
    }

    @DeleteMapping("/{id}")
    public CountryResponse delete(@PathVariable Integer id){
        return countryService.delete(id);
    }
}
