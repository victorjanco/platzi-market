package com.platzi.market.domain.repository;

import com.platzi.market.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> getAll();
    Optional<Customer> getCustomer(String id);
    Customer save(Customer customer);
    void delete(String id);
}
