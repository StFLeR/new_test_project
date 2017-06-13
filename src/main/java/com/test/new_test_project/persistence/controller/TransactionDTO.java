package com.test.new_test_project.persistence.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.new_test_project.persistence.entity.CreditCard;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by aamitreikin on 13.06.17.
 */
public class TransactionDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    private BigDecimal summ;
    private Long creditCardId;
    private Date validDate;

    public BigDecimal getSumm() {
        return summ;
    }

    public void setSumm(BigDecimal summ) {
        this.summ = summ;
    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }
    @JsonCreator
    public TransactionDTO (@JsonProperty("id") Long id,
                           @JsonProperty("summ") BigDecimal summ,
                           @JsonProperty("creditCardId") Long creditCardId,
                           @JsonProperty("validDate") Date validDate){
        this.id=id;
        this.summ=summ;
        this.creditCardId=creditCardId;
        this.validDate=validDate;
    }
    public TransactionDTO (Long id, BigDecimal summ, CreditCard creditCardId, Date validDate){
        this(id, summ, creditCardId.getId(), validDate);
    }
}
