package com.test.new_test_project.persistence.controller;

/**
 * Created by aamitreikin on 05.06.17.
 */
public class BankDTO {
    private String name;
    private String adres;
    private Boolean activ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Boolean getActiv() {
        return activ;
    }

    public void setActiv(Boolean activ) {
        this.activ = activ;
    }
}
