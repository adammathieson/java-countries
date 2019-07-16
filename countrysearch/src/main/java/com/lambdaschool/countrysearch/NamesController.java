package com.lambdaschool.countrysearch;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static java.lang.Character.*;

@RestController
@RequestMapping("/names")
public class NamesController
{
    // Get all names "/names/all"
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountrysearchApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(CountrysearchApplication.countryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountries = CountrysearchApplication.countryList.getAllCountries(c -> c.getName().toUpperCase().charAt(0) == toUpperCase(letter));
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountryNameSize(@PathVariable int number)
    {
        ArrayList<Country> rtnCountries = CountrysearchApplication.countryList.getAllCountries(c -> c.getName().length() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity(rtnCountries, HttpStatus.OK);
    }

}
