package io.github.lvbo.learn.guava.functional.model;

public class City {
    private String name;
    private String zipCode;
    private int population;
    private Climate climate;
    private double averageRainfall;

    public City(String name, String zipCode, int population) {
        this.name = name;
        this.zipCode = zipCode;
        this.population = population;
    }

    public double getAverageRainfall() {
        return averageRainfall;
    }

    public void setAverageRainfall(double averageRainfall) {
        this.averageRainfall = averageRainfall;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String toString() {
        return name;
    }
}
