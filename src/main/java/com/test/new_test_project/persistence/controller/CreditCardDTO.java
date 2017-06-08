package com.test.new_test_project.persistence.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.new_test_project.persistence.entity.Users;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by aamitreikin on 07.06.17.
 */
public class CreditCardDTO {
    private Integer creditNamber;
    private Date validDate;
    private BigDecimal amouns;
    private Boolean active;
    private Long usersId;

    @JsonCreator
    public CreditCardDTO(@JsonProperty("creditNamber") Integer creditNamber,
                         @JsonProperty("validDate") Date validDate,
                         @JsonProperty("amouns")  BigDecimal amouns,
                         @JsonProperty("active") Boolean active,
                         @JsonProperty("usersId") Long usersId) {
        this.creditNamber = creditNamber;
        this.validDate = validDate;
        this.amouns = amouns;
        this.active = active;
        this.usersId = usersId;
    }

    public CreditCardDTO(Boolean active, BigDecimal amouns, Integer creditNamber, Users users, Date validDate) {
        this(creditNamber, validDate, amouns, active, users.getId());
    }


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Integer getCreditNamber() {
        return creditNamber;
    }

    public void setCreditNamber(Integer creditNamber) {
        this.creditNamber = creditNamber;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public BigDecimal getAmouns() {
        return amouns;
    }

    public void setAmouns(BigDecimal amouns) {
        this.amouns = amouns;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }
}
