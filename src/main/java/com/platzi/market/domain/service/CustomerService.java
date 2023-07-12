package com.platzi.market.domain.service;

import com.platzi.market.domain.Customer;
import com.platzi.market.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.getAll();
    }
    public Optional<Customer> getCustomer(int id){
        return customerRepository.getCustomer(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
    public boolean delete(int id){
        return customerRepository.getCustomer(id)
                .map(customer -> {
                    customerRepository.delete(id);
                    return true;
                })
                .orElse(false);
    }
}
