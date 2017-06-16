package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.entity.BankOfice;
import com.test.new_test_project.persistence.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aamitreikin on 06.06.17.
 */
@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Iterable<Users> findBybankOficeId(Long id);
}
