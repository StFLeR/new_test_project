package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.controller.CreditCardDTO;
import com.test.new_test_project.persistence.entity.CreditCard;
import com.test.new_test_project.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by aamitreikin on 07.06.17.
 */
@Repository
public class CardRepository {
    //
    @Autowired
    private UserRepository userRepository;
    //

    @Autowired
    private CreditCardRepository creditCardRepository;

    public Iterable<CreditCard> findAll(){return creditCardRepository.findAll();}

    public CreditCard create(CreditCardDTO creditCardDTO){
        Users users = userRepository.findOne(creditCardDTO.getUsersId());
        return creditCardRepository.save(
                new     CreditCard(creditCardDTO.getId(),
                        creditCardDTO.getCreditNamber(),
                        creditCardDTO.getValidDate(),
                        creditCardDTO.getAmouns(),
                        creditCardDTO.getActive(),
                        users));
    }

    public  CreditCard gateOne(Integer id){
        return creditCardRepository.findOne(id.longValue());
    }

    public CreditCard update(Integer id,CreditCardDTO creditCardDTO){
        Users users = userRepository.findOne(creditCardDTO.getUsersId());
        CreditCard creditCard = creditCardRepository.findOne(id.longValue());
        creditCard.setCreditNamber(creditCardDTO.getCreditNamber());
        creditCard.setValidDate(creditCardDTO.getValidDate());
        creditCard.setAmouns(creditCardDTO.getAmouns());
        creditCard.setActive(creditCardDTO.getActive());
        creditCard.setUsers(users);
        creditCardRepository.save(creditCard);
        return creditCardRepository.findOne(id.longValue());
    }

    public Boolean delete(Integer id){
        CreditCard creditCard = creditCardRepository.findOne(id.longValue());
        creditCard.setActive(false);
        creditCardRepository.save(creditCard);
        return true;
    }
}

