package com.rodzyn.homework5.service;

import com.rodzyn.homework5.model.nameDay.NameDay;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameDayService {

//    private NameDay namedays() {
//        RestTemplate restTemplate = new RestTemplate();
//        NameDay nameDats = restTemplate.getForObject("https://api.abalin.net/today?country=pl", NameDay.class);
//        return nameDats;
//     }
//
//     public Integer getDay(){
//         return namedays().getData().get(0).getDates().getDay();
//     }
//    public Integer getMonth(){
//        return namedays().getData().get(0).getDates().getMonth();
//    }
//    public String getNames(){
//        return namedays().getData().get(0).getNamedays().getPl();
//    }
//
//    public String getNameDay(){
//        return "" + getDay() + "." + getMonth();
//    }

}
