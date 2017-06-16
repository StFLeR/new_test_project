package com.test.new_test_project.persistence.service;

import com.test.new_test_project.persistence.controller.UserDTO;
import com.test.new_test_project.persistence.entity.BankOfice;
import com.test.new_test_project.persistence.entity.Users;
import com.test.new_test_project.persistence.repository.BankRepository;
import com.test.new_test_project.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by aamitreikin on 06.06.17.
 */
@Transactional
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    //
    @Autowired
    private BankRepository bankRepository;
    //


    public Iterable<Users> findAll(){return usersRepository.findAll();
    }
//    public UserDTO create(UserDTO userDTO){
//     //return usersRepository.create(new Users("1", "2", true, 1));
////        if (bankRepository.gateOne(userDTO.getBankOfice().intValue()) != null && bankRepository.gateOne(userDTO.getBankOfice().intValue()).getActiv() == true){
////            return usersRepository.create(userDTO);
////        }
////        else {
////            throw new AcceptPendingException();
////
////        }
//        Users cc = usersRepository.create(userDTO);
//        UserDTO dto = convert(cc);
//        return dto;
//    }
//
    public UserDTO create(UserDTO userDTO){
        Users cc = usersRepository.create(userDTO);
        UserDTO dto = convert(cc);
        return dto;
    }

        private UserDTO convert(Users cc) {
        return new UserDTO(cc.getId(), cc.getLastName(), cc.getFirstName(),cc.getActiv(), cc.getBankOfice());
    }

    public UserDTO gateOne(Integer id){
        Users cc = usersRepository.gateOne(id);
        UserDTO dto = convert(cc);
        return dto;
    }

    public UserDTO update(Integer id, UserDTO userDTO){
        Users cc = usersRepository.update(id, userDTO);
        UserDTO dto = convert(cc);
        return dto;
    }

    public Boolean delete(Integer id){
        return usersRepository.delete(id);
    }

    public Iterable<Users> findAllUsers (Long id){
        return usersRepository.findAllUsers(id);}


}
