package de.ait.services;

import de.ait.models.Product;

import java.util.List;

public interface ProductService {

    void addProduct(String name);

    List<Product> getProducts();
}
