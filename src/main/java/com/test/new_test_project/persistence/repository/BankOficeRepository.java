package com.test.new_test_project.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.test.new_test_project.persistence.entity.BankOfice;

/**
 * Created by aamitreikin on 05.06.17.
 */
@Repository
public interface BankOficeRepository extends CrudRepository<BankOfice, Long> {
}