package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aamitreikin on 13.06.17.
 */
public interface TransactionsRepositiry extends CrudRepository<Transaction, Long> {
}
