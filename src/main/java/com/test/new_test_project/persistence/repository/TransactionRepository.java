package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.controller.TransactionDTO;
import com.test.new_test_project.persistence.entity.CreditCard;
import com.test.new_test_project.persistence.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by aamitreikin on 13.06.17.
 */
@Repository
public class TransactionRepository {
    @Autowired
    private TransactionsRepositiry transactionsRepositiry;
    @Autowired
    private CreditCardRepository creditCardRepository;

    public Iterable<Transaction> findAll(){
        return transactionsRepositiry.findAll();
    }

    public Transaction create(TransactionDTO transactionDTO){
        CreditCard creditCard =creditCardRepository.findOne(transactionDTO.getCreditCardId());
        return transactionsRepositiry.save(new Transaction(
                transactionDTO.getId(),
                transactionDTO.getSumm(),
                creditCard,
                transactionDTO.getValidDate()));
    }
}
