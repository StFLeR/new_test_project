package com.test.new_test_project.persistence.service;

import com.test.new_test_project.persistence.controller.BankDTO;
import com.test.new_test_project.persistence.entity.BankOfice;
import com.test.new_test_project.persistence.entity.Users;
import com.test.new_test_project.persistence.repository.BankOficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.new_test_project.persistence.repository.BankRepository;

/**
 * Created by aamitreikin on 05.06.17.
 */
@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private BankOficeRepository bankOficeRepository;

    public Iterable<BankOfice> findAll(){
        return bankRepository.findAll();
    }

    public BankOfice gateOne(Integer id){
        return bankRepository.gateOne(id);
    }

    public BankOfice create(BankDTO bankDTO){
        return bankRepository.create(bankDTO);
    }

    public BankOfice update(Integer id, BankDTO bankDTO){
        return bankRepository.update(id, bankDTO);
    }

    public Boolean delete(Integer id){
        return bankRepository.delete(id);
    }
}
