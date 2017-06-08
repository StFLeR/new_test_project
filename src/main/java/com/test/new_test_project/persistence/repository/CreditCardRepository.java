package com.test.new_test_project.persistence.repository;

import com.test.new_test_project.persistence.entity.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aamitreikin on 07.06.17.
 */
@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
}
