package com.rodzyn.homework5.service;

import com.rodzyn.homework5.model.currency.Currency;

import com.rodzyn.homework5.model.currency.Rates;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CurrencyService {

    private int numberOFattempt;

    public int getNumberOFattempt() {
        return numberOFattempt;
    }

    public void setNumberOFattempt(int numberOFattempt) {
        this.numberOFattempt = numberOFattempt;
    }

    public List<String> selectCurrency = new ArrayList<>();

    private String basicCurrency = "pln";

    public String getBasicCurrency() {
        return basicCurrency;
    }

    private double rate = 0d;

    public CurrencyService(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    /*
    create comment to game
     */
    public String rateComment(){
        Object rateCurrency = mapCurrency().get(selectCurrency.get(0));
        String str = rateCurrency.toString();
        double rateCur = Double.valueOf(str).doubleValue() *100;
        rateCur = Math.round(rateCur);
        rateCur = rateCur/100;
        setNumberOFattempt(getNumberOFattempt()+1);
        if(rateCur > getRate()){
            return "your number is too small";
        }else if(rateCur < getRate()){
            return "your number is too big";
        }
        return "you win";
    }

    /*
    get all needed date from URL
     */
    public Currency currency(){
        RestTemplate restTemplate = new RestTemplate();
        Currency currency = restTemplate.getForObject(String.format(
                "https://api.exchangerate-api.com/v4/latest/%s", basicCurrency)
                , Currency.class);
        return currency;
    }

    /*
    select random currency
     */
    public CurrencyService() {
        Random random = new Random();
        int ranNumber = random.nextInt(51);
        selectCurrency.add(listCurrency().get(ranNumber));
    }

    /*
    create list of all symbol currency
     */
    public List<String> listCurrency(){
        List<String> listCurrency = new ArrayList<>(mapCurrency().keySet());
        return listCurrency;
    }

    /*
    create map with symbol currency as key, and rate as value
     */
    public Map<String, Object> mapCurrency(){
        Map<String, Object> mapCurrency = new TreeMap<>();
        Rates rates = currency().getRates();
        mapCurrency.putIfAbsent("USD", rates.getUSD().toString());
        mapCurrency.putIfAbsent("AED", rates.getAED().toString());
        mapCurrency.putIfAbsent("ARS", rates.getARS().toString());
        mapCurrency.putIfAbsent("AUD", rates.getAUD().toString());
        mapCurrency.putIfAbsent("BGN", rates.getBSD().toString());
        mapCurrency.putIfAbsent("BRL", rates.getBRL().toString());
        mapCurrency.putIfAbsent("BSD", rates.getBSD().toString());
        mapCurrency.putIfAbsent("CAD", rates.getCAD().toString());
        mapCurrency.putIfAbsent("CHF", rates.getCHF().toString());
        mapCurrency.putIfAbsent("CLP", rates.getCLP().toString());
        mapCurrency.putIfAbsent("CNY", rates.getCNY().toString());
        mapCurrency.putIfAbsent("COP", rates.getCOP().toString());
        mapCurrency.putIfAbsent("CZK", rates.getCZK().toString());
        mapCurrency.putIfAbsent("DKK", rates.getDKK().toString());
        mapCurrency.putIfAbsent("DOP", rates.getDOP().toString());
        mapCurrency.putIfAbsent("EGP", rates.getEGP().toString());
        mapCurrency.putIfAbsent("EUR", rates.getEUR().toString());
        mapCurrency.putIfAbsent("FJD", rates.getFJD().toString());
        mapCurrency.putIfAbsent("GBP", rates.getGBP().toString());
        mapCurrency.putIfAbsent("GTQ", rates.getGTQ().toString());
        mapCurrency.putIfAbsent("HKD", rates.getHKD().toString());
        mapCurrency.putIfAbsent("HRK", rates.getHRK().toString());
        mapCurrency.putIfAbsent("HUF", rates.getHUF().toString());
        mapCurrency.putIfAbsent("IDR", rates.getIDR().toString());
        mapCurrency.putIfAbsent("ILS", rates.getILS().toString());
        mapCurrency.putIfAbsent("INR", rates.getINR().toString());
        mapCurrency.putIfAbsent("ISK", rates.getISK().toString());
        mapCurrency.putIfAbsent("JPY", rates.getJPY().toString());
        mapCurrency.putIfAbsent("KRW", rates.getKRW().toString());
        mapCurrency.putIfAbsent("KZT", rates.getKZT().toString());
        mapCurrency.putIfAbsent("MXN", rates.getMXN().toString());
        mapCurrency.putIfAbsent("MYR", rates.getMYR().toString());
        mapCurrency.putIfAbsent("NOK", rates.getNOK().toString());
        mapCurrency.putIfAbsent("NZD", rates.getNZD().toString());
        mapCurrency.putIfAbsent("PAB", rates.getPAB().toString());
        mapCurrency.putIfAbsent("PEN", rates.getPEN().toString());
        mapCurrency.putIfAbsent("PHP", rates.getPHP().toString());
        mapCurrency.putIfAbsent("PKR", rates.getPKR().toString());
        mapCurrency.putIfAbsent("PLN", rates.getPLN().toString());
        mapCurrency.putIfAbsent("PYG", rates.getPYG().toString());
        mapCurrency.putIfAbsent("RON", rates.getRON().toString());
        mapCurrency.putIfAbsent("RUB", rates.getRUB().toString());
        mapCurrency.putIfAbsent("SAR", rates.getSAR().toString());
        mapCurrency.putIfAbsent("SEK", rates.getSEK().toString());
        mapCurrency.putIfAbsent("SGD", rates.getSGD().toString());
        mapCurrency.putIfAbsent("THB", rates.getTHB().toString());
        mapCurrency.putIfAbsent("TRY", rates.getTRY().toString());
        mapCurrency.putIfAbsent("TWD", rates.getTWD().toString());
        mapCurrency.putIfAbsent("UAH", rates.getUAH().toString());
        mapCurrency.putIfAbsent("UYU", rates.getUYU().toString());
        mapCurrency.putIfAbsent("ZAR", rates.getZAR().toString());
        return mapCurrency;
    }
}

