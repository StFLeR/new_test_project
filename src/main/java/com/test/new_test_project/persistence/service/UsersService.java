package com.test.new_test_project.persistence.service;

import com.test.new_test_project.persistence.controller.UserDTO;
import com.test.new_test_project.persistence.entity.Users;
import com.test.new_test_project.persistence.repository.BankRepository;
import com.test.new_test_project.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public Iterable<Users> findAll(){
        return usersRepository.findAll();
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

    public Users gateOne(Integer id){return usersRepository.gateOne(id);}

    public Users update(Integer id, UserDTO userDTO){return usersRepository.update(id, userDTO);}
}
