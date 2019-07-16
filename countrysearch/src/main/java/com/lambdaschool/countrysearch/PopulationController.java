package com.lambdaschool.countrysearch;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    // Get countries pop with people var
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getPopulationByVariable(@PathVariable long people)
    {
        ArrayList<Country> rtnCountries = CountrysearchApplication.countryList.getAllCountries(c -> c.getPopulation() >= people);

        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // Get country with min pop
    @GetMapping(value = "/size/min", produces = {"application/json"})
    public ResponseEntity<?> getMinPopulation()
    {
        CountrysearchApplication.countryList.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        Country rtnCountries = CountrysearchApplication.countryList.countryList.get(0);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    // Get country with max pop
    @GetMapping(value = "/size/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxPopulation()
    {
        CountrysearchApplication.countryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        Country rtnCountries = CountrysearchApplication.countryList.countryList.get(0);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }
}
