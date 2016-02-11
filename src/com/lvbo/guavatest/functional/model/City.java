/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.functional.model;

/**
 * �๦������:
 * <ul>
 * <li><br>
 * </ul>
 * �޸ļ�¼��<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/10 11:09
 */
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
