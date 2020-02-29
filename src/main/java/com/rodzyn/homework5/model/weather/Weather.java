package com.rodzyn.homework5.model.weather;

public class Weather {

    private String date;
    private String name;
    private String temperature;
    private String pressure;
    private String abbreviation;

    public Weather(String date, String name, String temperature, String pressure, String abbreviation) {
        this.date = date;
        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
        this.abbreviation = abbreviation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", temperature='" + temperature + '\'' +
                ", pressure='" + pressure + '\'' +
                ", abbrivation='" + abbreviation + '\'' +
                '}';
    }
}
