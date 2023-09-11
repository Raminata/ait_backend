package de.ait.repositories;


import de.ait.models.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    List<Product> findAll();

}
