package com.test.new_test_project.persistence.controller;

import com.test.new_test_project.persistence.entity.Transaction;
import com.test.new_test_project.persistence.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aamitreikin on 13.06.17.
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/api/v1/transacts")
    public Iterable<Transaction> findAll() {
        return transactionService.findAll();
    }

    @PostMapping("/api/v1/transacts")
    public TransactionDTO create(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.create(transactionDTO);
    }
}
