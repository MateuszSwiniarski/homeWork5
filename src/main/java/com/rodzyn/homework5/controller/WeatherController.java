package com.rodzyn.homework5.controller;

import com.rodzyn.homework5.model.weather.City;
import com.rodzyn.homework5.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/weather")
@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("weathers", weatherService.getWeatherDetails());
        model.addAttribute("newCity", new City());
        return "weather";
    }

    @PostMapping("/findcar")
    public String findCity(@ModelAttribute(value = "nameCity") City city){
        weatherService.getCity.remove(0);
        weatherService.getCity.add(city);
        return "redirect:/api/weather";
    }

}
