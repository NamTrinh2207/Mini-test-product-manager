package com.example.productmanagerment.service;

import com.example.productmanagerment.model.Product;

import java.util.List;

public interface IProduct {
    List<Product> listProduct();
    void create(Product product);
    void update(int id, Product product);
    void remove(int id);
}