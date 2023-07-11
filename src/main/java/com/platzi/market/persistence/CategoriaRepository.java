package com.platzi.market.persistence;

import com.platzi.market.domain.Category;
import com.platzi.market.domain.repository.CategoryRepository;
import com.platzi.market.persistence.crud.CategoriaCrudRepository;
import com.platzi.market.persistence.entity.Categoria;
import com.platzi.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CategoriaRepository implements CategoryRepository {
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    @Autowired
    private CategoryMapper mapper;
    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return mapper.toCategorys(categorias);
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        Optional<Categoria> opteionalCategoria = categoriaCrudRepository.findById(categoryId);
        return opteionalCategoria.map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = categoriaCrudRepository.save(mapper.toCategoria(category));
        return mapper.toCategory(categoria);
    }

    @Override
    public void delete(int categoryId) {

    }
}
