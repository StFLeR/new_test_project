package com.test.new_test_project.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.Constraint;

/**
 * Created by aamitreikin on 05.06.17.
 */
@Entity
public class BankOfice {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    public String getName() {
        return name;
    }

    public String getAdres() {
        return adres;
    }
    //делаем проверку на уникальное значение
    //@UniqueConstraint(columnNames={"name"})
    @Column(unique=true)
    private String name;

    private String adres;
    private Boolean activ;

    public void setName(String name) {
        this.name = name;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setActiv(Boolean activ) {
        this.activ = activ;
    }

    public Boolean getActiv() {

        return activ;
    }

    protected BankOfice() {}


    public BankOfice(String name, String adres, Boolean activ) {
        this.name = name;
        this.adres = adres;
        this.activ = activ;
    }


    public Long getId() {
        return id;
    }

    public String name() {
        return name;
    }

    public String adres() {
        return adres;
    }

    public Boolean activ(){return activ;}

    @Override
    public String toString() {
        return String.format(
                "BankOfice[id=%d, name='%s', adres='%s', activ='%s']",
                id, name, adres, activ);
    }


}
