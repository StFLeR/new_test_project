package com.test.new_test_project.persistence.entity;

import javax.persistence.*;

/**
 * Created by aamitreikin on 06.06.17.
 */
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String firstName;

    //f@Column(unique=true)
    private String lastName;
    private Boolean activ= true;

    @ManyToOne
    @JoinColumn(name= "bank_ofice_id")
    private BankOfice bankOfice;

    protected Users() {}

    public Users(String firstName, String lastName, Boolean activ, BankOfice bankOfice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.activ = activ;
        this.bankOfice = bankOfice;
    }

    public BankOfice getBankOfice() {
        return bankOfice;
    }

    public void setBankOfice(BankOfice bankOfice) {
        this.bankOfice = bankOfice;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getActiv() {
        return activ;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActiv(Boolean activ) {
        this.activ = activ;
    }

    @Override
    public String toString() {
        return String.format(
                "Users[id=%d, firstName='%s', lastName='%s', activ='%s', bankOfice='%s']",
                id, firstName, lastName, activ, bankOfice);
    }
}
