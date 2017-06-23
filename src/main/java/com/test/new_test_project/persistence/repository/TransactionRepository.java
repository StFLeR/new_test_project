package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.controller.TransactionDTO;
import com.test.new_test_project.persistence.entity.CreditCard;
import com.test.new_test_project.persistence.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by aamitreikin on 13.06.17.
 */
@Repository
public class TransactionRepository {
    @Autowired
    private TransactionsRepositiry transactionsRepositiry;
    @Autowired
    private CreditCardRepository creditCardRepository;

    public Iterable<Transaction> findAll() {
        return transactionsRepositiry.findAll();
    }

    private Boolean update(CreditCard creditCard, BigDecimal bigDecimal) {
        CreditCard creditCard1 = creditCardRepository.findOne(creditCard.getId());
        creditCard1.setAmouns(bigDecimal);
        creditCardRepository.save(creditCard1);
        return true;
    }

    public Transaction create(TransactionDTO transactionDTO) {
        CreditCard creditCard1 = creditCardRepository.findOne(transactionDTO.getCreditCardId());
        CreditCard creditCard2 = creditCardRepository.findOne(transactionDTO.getAccruedCreditCardId());
        Transaction transaction = transactionsRepositiry.save(new Transaction(
                transactionDTO.getId(),
                transactionDTO.getSumm(),
                creditCard1,
                transactionDTO.getValidDate(),
                creditCard2));
        //создание оплаты. списываем с карты
        BigDecimal bigDecimal1;//=new BigDecimal(0);;
        bigDecimal1 = creditCard1.getAmouns().subtract(transactionDTO.getSumm());
        ////создание оплаты. пополнение карты
        BigDecimal bigDecimal2;//=new BigDecimal(0);;
        bigDecimal2 = creditCard2.getAmouns().add(transactionDTO.getSumm());
        //обновление считов
        update(creditCard1, bigDecimal1);
        update(creditCard2, bigDecimal2);

        return transaction;
    }
}
