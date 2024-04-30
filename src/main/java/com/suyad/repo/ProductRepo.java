package com.suyad.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suyad.Entitys.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{

}
