package com.rodzyn.homework5.controller;

import com.rodzyn.homework5.service.NameDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/nameday")
public class NameDayController {

    private NameDayService nameDayService;

    @Autowired
    public NameDayController(NameDayService nameDayService) {
        this.nameDayService = nameDayService;

    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("nameDay", "czwartek");
        model.addAttribute("day", "dzis");
        model.addAttribute("month", "luty");
        model.addAttribute("names", "mateusz, dariusz");
//        model.addAttribute("nameDay", nameDayService.getNameDay());
//        model.addAttribute("day", nameDayService.getDay());
//        model.addAttribute("month", nameDayService.getMonth());
//        model.addAttribute("names", nameDayService.getNames());
        return "nameday";
    }
}
