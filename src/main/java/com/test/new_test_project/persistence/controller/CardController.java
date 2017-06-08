package com.test.new_test_project.persistence.controller;

import com.test.new_test_project.persistence.entity.CreditCard;
import com.test.new_test_project.persistence.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aamitreikin on 07.06.17.
 */
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/srv/card")
    public Iterable<CreditCard> findAll(){return cardService.findAll();}

    @PostMapping(value = "/srv/card", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CreditCardDTO create(@RequestBody CreditCardDTO creditCardDTO){return cardService.create(creditCardDTO);}

    @GetMapping("/srv/card/{id}")
    public CreditCardDTO gateOne(@PathVariable Integer id){
        return cardService.gateOne(id);
    }
}
