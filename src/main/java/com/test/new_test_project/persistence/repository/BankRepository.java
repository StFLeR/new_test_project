package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.controller.BankDTO;
import com.test.new_test_project.persistence.entity.BankOfice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by aamitreikin on 05.06.17.
 */
@Repository
public class BankRepository {


    @Autowired
    private BankOficeRepository bankOficeRepository;

    public Iterable<BankOfice> findAll(){
        return bankOficeRepository.findAll();
    }

    public BankOfice gateOne(Integer id){
        return bankOficeRepository.findOne(id.longValue());
    }

    public BankOfice create(BankDTO bankDTO){
        return bankOficeRepository.save(new BankOfice(bankDTO.getName(), bankDTO.getAdres(), bankDTO.getActiv()));
    }

    public BankOfice update(Integer id, BankDTO bankDTO){
        BankOfice bankOfice = bankOficeRepository.findOne(id.longValue());
        bankOfice.setName(bankDTO.getName());
        bankOfice.setAdres(bankDTO.getAdres());
        bankOfice.setActiv(bankDTO.getActiv());
        bankOficeRepository.save(bankOfice);
        return bankOficeRepository.findOne(id.longValue());
    }

    public Boolean delete(Integer id){
        BankOfice bankOfice = bankOficeRepository.findOne(id.longValue());
        bankOfice.setActiv(false);
        bankOficeRepository.save(bankOfice);
        return true;
    }



}
