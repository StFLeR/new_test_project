package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.controller.UserDTO;
import com.test.new_test_project.persistence.entity.BankOfice;
import com.test.new_test_project.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by aamitreikin on 06.06.17.
 */
@Repository
public class UsersRepository {
    static int id = 0;

    @Autowired
    private UserRepository userRepository;
    //
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private BankOficeRepository bankOficeRepository;
    //

    public Iterable<Users> findAll(){
        return userRepository.findAll();
    }

    public Users gateOne(Integer id){return userRepository.findOne(id.longValue());}

    public Users create(UserDTO userDTO){
        BankOfice bankOfice = bankOficeRepository.findOne(userDTO.getBankOficeId());
        return userRepository.save(new Users(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getActiv(),  bankOfice));
    }

    public Users update(Integer id, UserDTO userDTO){
        BankOfice bankOfice = bankOficeRepository.findOne(userDTO.getBankOficeId());
        Users users =userRepository.findOne(id.longValue());
        users.setFirstName(userDTO.getFirstName());
        users.setLastName(userDTO.getLastName());
        users.setActiv(userDTO.getActiv());
        users.setBankOfice(bankOfice);
        userRepository.save(users);
        return userRepository.findOne(id.longValue());
    }

    public Boolean delete(Integer id){
        Users users =userRepository.findOne(id.longValue());
        users.setActiv(false);
        userRepository.save(users);
        return true;
    }
}
