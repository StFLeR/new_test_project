package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.controller.CreditCardDTO;
import com.test.new_test_project.persistence.entity.CreditCard;
import com.test.new_test_project.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by aamitreikin on 07.06.17.
 */
@Repository
public class CardRepository {
    //
    @Autowired
    private UserRepository userRepository;
    //
    //

    @Autowired
    private CreditCardRepository creditCardRepository;

    public Iterable<CreditCard> findAll(){return creditCardRepository.findAll();}

    public CreditCard create(CreditCardDTO creditCardDTO){
        Users users = userRepository.findOne(creditCardDTO.getUsersId());
        return creditCardRepository.save(new CreditCard(creditCardDTO.getCreditNamber(), creditCardDTO.getValidDate(), creditCardDTO.getAmouns(), creditCardDTO.getActive(), users));}
}
