package com.lambdaschool.countrysearch;

public class Country
{
    private String name;
    private long population;
    private long landMass;
    private int medianAge;

    public Country(String name, long population, long landMass, int medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public Country(Country toClone)
    {
        this.name = toClone.name;
        this.population = toClone.population;
        this.landMass = toClone.landMass;
        this.medianAge = toClone.medianAge;
    }

    public String getName()
    {
        return name;
    }

    public long getPopulation()
    {
        return population;
    }

    public long getLandMass()
    {
        return landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "name='" + name + '\'' + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';
    }
}
