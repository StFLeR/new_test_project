package com.test.new_test_project.persistence.service;

import com.test.new_test_project.persistence.controller.CreditCardDTO;
import com.test.new_test_project.persistence.entity.CreditCard;
import com.test.new_test_project.persistence.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aamitreikin on 07.06.17.
 */
@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Iterable<CreditCard> findAll() {
        return cardRepository.findAll();
    }

    public CreditCardDTO create(CreditCardDTO creditCardDTO) {
        CreditCard cc = cardRepository.create(creditCardDTO);
        CreditCardDTO dto = convert(cc);
        return dto;
    }

    private CreditCardDTO convert(CreditCard cc) {
        return new CreditCardDTO(cc.getId(),
                cc.getActive(),
                cc.getAmouns(),
                cc.getCreditNamber(),
                cc.getUsers(),
                cc.getValidDate());
    }

    public CreditCardDTO gateOne(Integer id) {
        CreditCard cc = cardRepository.gateOne(id);
        CreditCardDTO dto = convert(cc);
        return dto;
    }

    public CreditCardDTO update(Integer id, CreditCardDTO creditCardDTO) {
        CreditCard cc = cardRepository.update(id, creditCardDTO);
        CreditCardDTO dto = convert(cc);
        return dto;
    }

    public Boolean delete(Integer id) {
        return cardRepository.delete(id);
    }


}
