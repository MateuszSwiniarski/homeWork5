package com.rodzyn.homework5.model.weather;

import org.springframework.stereotype.Service;

@Service
public class City {

    private String nameCity;

    public City(String nameCity) {
        this.nameCity = nameCity;
    }

    public City() {
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public String toString() {
        return "City{" +
                "nameCity='" + nameCity + '\'' +
                '}';
    }
}
