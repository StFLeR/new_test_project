package com.test.new_test_project.persistence.service;

import com.test.new_test_project.persistence.controller.TransactionDTO;
import com.test.new_test_project.persistence.entity.CreditCard;
import com.test.new_test_project.persistence.entity.Transaction;
import com.test.new_test_project.persistence.repository.CreditCardRepository;
import com.test.new_test_project.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;

/**
 * Created by aamitreikin on 13.06.17.
 */
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;

    public Iterable<Transaction> findAll(){return transactionRepository.findAll();}

    public TransactionDTO create(TransactionDTO transactionDTO){
        CreditCard creditCard = creditCardRepository.findOne(transactionDTO.getCreditCardId());
        if (creditCardRepository.findOne(transactionDTO.getCreditCardId())!= null && creditCard.getAmouns().compareTo(transactionDTO.getSumm())==1){
        Transaction transaction=transactionRepository.create(transactionDTO);
        TransactionDTO dto = convert(transaction);
        return dto;}
        else {throw new EmptyStackException();}
    }

    private TransactionDTO convert(Transaction transaction){
        return new TransactionDTO(transaction.getId(),
                transaction.getSum(),
                transaction.getCreditCardId(),
                transaction.getValidDate());
    }


}
