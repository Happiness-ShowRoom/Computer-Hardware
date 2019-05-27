package com.javarush.computer_hardware.service;

import com.javarush.computer_hardware.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.javarush.computer_hardware.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setNoteRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product getProductById(Integer id) {
        return this.repository.getOne(id);
    }

    @Override
    public void saveProduct(Product product) {
        this.repository.save(product);
    }

    @Override
    public void updateProduct(Integer id, String name, Integer quantity, boolean isNecessary) {
        Product updated = this.repository.getOne(id);
        updated.setNecessary(isNecessary);
        updated.setName(name);
        updated.setQuantity(quantity);
        this.repository.save(updated);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.repository.delete(id);
    }

    @Override
    public List<Product> findAllByNecessaryIsTrueSorted() {
        return this.repository.findAllByNecessaryIsTrueOrderByQuantity();
    }
    @Override
    public Page<Product> findAllByOrderByName(Pageable pageable) {
        return this.repository.findAllByOrderByName(pageable);
    }

    @Override
    public Page<Product> findAllByNecessaryIsFalse(Pageable pageable) {
        return this.repository.findAllByNecessaryIsFalseOrderByName(pageable);
    }

    @Override
    public Page<Product> findAllByNecessaryIsTrue(Pageable pageable) {
        return this.repository.findAllByNecessaryIsTrueOrderByName(pageable);
    }

    @Override
    public Page<Product> findProductByName(Pageable pageable, String name) {
        return this.repository.findProductsByNameContains(pageable, name);
    }
}
