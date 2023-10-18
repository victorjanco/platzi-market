package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Categoria;
import com.platzi.market.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {

}
