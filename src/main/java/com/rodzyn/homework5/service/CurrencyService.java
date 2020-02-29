package com.rodzyn.homework5.service;

import com.rodzyn.homework5.model.currency.Currency;

import com.rodzyn.homework5.model.currency.Rates;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

@Service
public class CurrencyService {


    private RestTemplate restTemplate = new RestTemplate();
    public CurrencyService() {
        Currency currency = restTemplate.getForObject("https://api.exchangerate-api.com/v4/latest/usd", Currency.class);

        System.out.println(currency.getDate());
        System.out.println(currency.getBase());
        System.out.println(currency.getTimeLastUpdated());
        System.out.println(currency.getRates().getAdditionalProperties().size());

        Map<String, Object> additionalProperties = currency.getRates().getAdditionalProperties();

        Set<String> keySet = additionalProperties.keySet();
        System.out.println(additionalProperties.size());

    }


}

