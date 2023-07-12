package com.platzi.market.persistence;

import com.platzi.market.domain.Customer;
import com.platzi.market.domain.repository.CustomerRepository;
import com.platzi.market.persistence.crud.ClienteCrudRepository;
import com.platzi.market.persistence.entity.Cliente;
import com.platzi.market.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements CustomerRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<Customer> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return customerMapper.toCustomers(clientes);
    }

    @Override
    public Optional<Customer> getCustomer(int id) {
        Optional<Cliente> optionalCliente = clienteCrudRepository.findById(id);
        return optionalCliente.map(cliente -> customerMapper.toCustomer(cliente));
    }

    @Override
    public Customer save(Customer customer) {
        Cliente cliente = clienteCrudRepository.save(customerMapper.toCliente(customer));
        return customerMapper.toCustomer(cliente);
    }

    @Override
    public void delete(int id) {
        clienteCrudRepository.deleteById(id);
    }
}
