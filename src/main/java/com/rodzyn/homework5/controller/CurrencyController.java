package com.rodzyn.homework5.controller;

import com.rodzyn.homework5.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.lang.Double.valueOf;

@Controller
@RequestMapping("/api/cantor")
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public String get(Model model){
        model.addAttribute("basicCurrency", currencyService.getBasicCurrency());
        model.addAttribute("randomCurrency", currencyService.selectCurrency.get(0));
        model.addAttribute("rate", new CurrencyService());
        model.addAttribute("comment", currencyService.rateComment());
        model.addAttribute("attempt", currencyService.getNumberOFattempt());
        return "cantor";
    }

    @PostMapping
    public String getValue(@ModelAttribute(value = "rate") String rate){
        Double value = null;
        try {
            value =Double.parseDouble(rate);
            currencyService.setRate(value);
            return "redirect:/api/cantor";
        }
        catch(NumberFormatException e) {
            return "redirect:/api/cantor";
        }
    }
}
