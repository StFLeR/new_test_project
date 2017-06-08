package com.test.new_test_project.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by aamitreikin on 07.06.17.
 */
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(unique=true)
    private Integer creditNamber;
    private Date validDate;
    private BigDecimal amouns;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name= "users_id")
    private Users users;

    public CreditCard(Long id,Integer creditNamber, Date validDate, BigDecimal amouns, Boolean active, Users users){
        this.id=id;
        this.creditNamber =creditNamber;
        this.validDate =validDate;
        this.amouns = amouns;
        this.active = active;
        this.users = users;
    }

    protected CreditCard(){}

    public Long getId() {
        return id;
    }

    public Integer getCreditNamber() {

        return creditNamber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getValidDate() {
        return validDate;
    }

    public BigDecimal getAmouns() {
        return amouns;
    }

    public Users getUsers() {
        return users;
    }

    public void setCreditNamber(Integer creditNamber) {
        this.creditNamber = creditNamber;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public void setAmouns(BigDecimal amouns) {
        this.amouns = amouns;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return String.format(
                "CreditCard[id=%d, creditNamber='%s', validDate='%s', amouns='%s', users='%s',  active='%s']",
                id, creditNamber, validDate, amouns, users, active);
    }
}
