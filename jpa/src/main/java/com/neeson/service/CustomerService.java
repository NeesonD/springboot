package com.neeson.service;

import com.neeson.domain.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

/**
 * Created by daile on 2017/9/1.
 */
@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(value = REQUIRED)
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }

}
