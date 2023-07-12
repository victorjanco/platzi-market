package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Customer;
import com.platzi.market.persistence.entity.Cliente;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings({
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "apellidos", target = "lastName"),
        @Mapping(source = "celular", target = "phone"),
        @Mapping(source = "direccion", target = "address"),
        @Mapping(source = "correoElectronico", target = "email")
    })
    Customer toCustomer(Cliente cliente);
    List<Customer> toCustomers(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    Cliente toCliente(Customer customer);
}
