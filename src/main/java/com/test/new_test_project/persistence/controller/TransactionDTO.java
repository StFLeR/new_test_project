package com.test.new_test_project.persistence.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.new_test_project.persistence.entity.CreditCard;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by aamitreikin on 13.06.17.
 */
public class TransactionDTO {
    private Long id;
    private BigDecimal summ;
    private Long creditCardId;
    private Date validDate;
    private Long accruedCreditCardId;
    @JsonCreator
    public TransactionDTO(@JsonProperty("id") Long id,
                          @JsonProperty("summ") BigDecimal summ,
                          @JsonProperty("creditCardId") Long creditCardId,
                          @JsonProperty("validDate") Date validDate,
                          @JsonProperty("accruedCreditCardId") Long accruedCreditCardId) {
        this.id = id;
        this.summ = summ;
        this.creditCardId = creditCardId;
        this.validDate = validDate;
        this.accruedCreditCardId = accruedCreditCardId;
    }

    public TransactionDTO(Long id, BigDecimal summ, CreditCard creditCardId, Date validDate, CreditCard accruedCreditCardId) {
        this(id, summ, creditCardId.getId(), validDate, accruedCreditCardId.getId());
    }

    public Long getId() {
        return id;
    }

    public Long getAccruedCreditCardId() {
        return accruedCreditCardId;
    }

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

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }
}
