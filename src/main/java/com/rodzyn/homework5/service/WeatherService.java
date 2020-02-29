package com.rodzyn.homework5.service;

import com.rodzyn.homework5.model.weather.City;
import com.rodzyn.homework5.model.weather.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    private RestTemplate restTemplate =  new RestTemplate();

    /*
    find city name and city ID from the link
    snf put it to the list
     */
    public List<String> getCityDetails(){
        WeatherSource[] getParent = restTemplate.getForObject(
                String.format("https://www.metaweather.com/api/location/search/?query=%s"
                        , getCity.get(0).getNameCity())
                        ,WeatherSource[].class);
        Map<String, String> cityparameters = new HashMap<>();

        for (WeatherSource weatherSource : getParent) {
            cityparameters.putIfAbsent("title", weatherSource.getTitle());
            cityparameters.putIfAbsent("woeid", weatherSource.getWoeid().toString());
        }
        List<String> cityDetail = new ArrayList<>();
        if(cityparameters.get("woeid") == null){
            cityDetail.add("Warsaw");
            cityDetail.add("523920");
            return cityDetail;
        }
        cityDetail.add(cityparameters.get("title"));
        cityDetail.add(cityparameters.get("woeid"));
        return cityDetail;
    }

    /*
    base on City ID form getCityDetails(), find the rest need detail
    and put everythink to the one list
     */
    public List<Weather> getWeatherDetails(){
        List<Weather> weatherDetails = new ArrayList<>();

        WeatherSource consolidatedWeather = restTemplate.getForObject("https://www.metaweather.com/api/location/"
                        + getCityDetails().get(1) + "/"
                        , WeatherSource.class);

        for(int i = 0; i< 6; i++) {
            weatherDetails.add(new Weather(
                    consolidatedWeather.getConsolidatedWeather().get(i).getApplicableDate()
                    , getCityDetails().get(0)
                    , String.format("%.1f",consolidatedWeather.getConsolidatedWeather().get(i).getTheTemp())
                    , String.format("%.1f",consolidatedWeather.getConsolidatedWeather().get(i).getAirPressure())
                    , String.format("https://www.metaweather.com/static/img/weather/png/64/%s.png"
                    ,consolidatedWeather.getConsolidatedWeather().get(i).getWeatherStateAbbr())
            ));
        }
        return weatherDetails;
    }


    public List<City> getCity = new ArrayList<>();

    public WeatherService(){
        City city1 = new City("Warsaw");
        getCity.add(city1);
    }
}
