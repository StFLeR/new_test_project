package com.test.new_test_project.persistence.controller;

import com.test.new_test_project.persistence.entity.BankOfice;
import com.test.new_test_project.persistence.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aamitreikin on 05.06.17.
 */
@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/srv/Ofice")
    public Iterable<BankOfice> findAll() {
        return bankService.findAll();
    }

    @GetMapping("/srv/Ofice/{id}")
    public BankOfice gateOne(@PathVariable("id") Integer id) {
        return bankService.gateOne(id);
    }

    @PostMapping("/srv/Ofice")
    public BankOfice create(@RequestBody BankDTO bankDTO) {
        return bankService.create(bankDTO);
    }

    @PutMapping("/srv/Ofice/{id}")
    public BankOfice update(@PathVariable("id") Integer id, @RequestBody BankDTO bankDTO) {
        return bankService.update(id, bankDTO);
    }

    @DeleteMapping("/srv/Ofice/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return bankService.delete(id);
    }

}
