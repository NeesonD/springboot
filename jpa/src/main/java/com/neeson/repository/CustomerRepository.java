package com.neeson.repository;

import com.neeson.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Created by daile on 2017/9/1.
 */
@Repository
@Transactional
public class CustomerRepository extends SimpleJpaRepository<Customer,Long>{

    @Autowired
    public CustomerRepository(EntityManager entityManager) {
        super(Customer.class,entityManager);
    }


}
