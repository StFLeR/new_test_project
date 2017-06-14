package com.test.new_test_project.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by aamitreikin on 13.06.17.
 */
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private BigDecimal summ;

    @ManyToOne
    @JoinColumn(name= "credit_card_id")
    private CreditCard creditCardId;
    private Date validDate;

    public Transaction(Long id, BigDecimal summ, CreditCard creditCardId, Date validDate){
        this.id=id;
        this.summ=summ;
        this.creditCardId=creditCardId;
        this.validDate=validDate;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSum() {

        return summ;
    }

    public void setSum(BigDecimal sum) {
        this.summ = summ;
    }

    public CreditCard getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(CreditCard creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    protected Transaction(){}

    @Override
    public String toString() {
        return String.format(
                "Transaction[id=%d, summ='%s', creditCardId='%s', validDate='%s']",
                id, summ, creditCardId, validDate);
    }

}
