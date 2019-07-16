package com.lambdaschool.countrysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountrysearchApplication
{
    static CountryList theList;
    public static void main(String[] args)
    {
        theList = new CountryList;
        SpringApplication.run(CountrysearchApplication.class, args);
    }

}
