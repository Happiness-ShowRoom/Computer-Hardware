package com.javarush.computer_hardware.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.javarush.computer_hardware.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    List<Product> findAllByNecessaryIsTrueOrderByQuantity();

    Page<Product> findAllByOrderByName(Pageable pageable);
    Page<Product> findAllByNecessaryIsFalseOrderByName(Pageable pageable);
    Page<Product> findAllByNecessaryIsTrueOrderByName(Pageable pageable);
    Page<Product> findProductsByNameContains(Pageable pageable, String name);
}
