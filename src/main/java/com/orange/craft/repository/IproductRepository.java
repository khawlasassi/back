package com.orange.craft.repository;

import com.orange.craft.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IproductRepository extends JpaRepository<Product, Long> {

}
