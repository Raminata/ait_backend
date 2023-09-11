package de.ait.services;


import de.ait.models.Product;
import de.ait.repositories.ProductRepository;
import de.ait.validators.NameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // делает конструктор для final-полей
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final NameValidator nameValidator;

    @Override
    public void addProduct(String name) {
        nameValidator.validate(name);

        Product product = new Product(name);

        productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
