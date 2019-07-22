package com.lambdaschool.countrysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountrysearchApplication
{
    static CountryList countryList;
    public static void main(String[] args)
    {
        countryList = new CountryList();
        SpringApplication.run(CountrysearchApplication.class, args);
    }

}
