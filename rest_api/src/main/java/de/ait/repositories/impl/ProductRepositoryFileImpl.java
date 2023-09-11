package de.ait.repositories.impl;

import de.ait.models.Product;
import de.ait.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryFileImpl implements ProductRepository {

    private final String fileName;

    public ProductRepositoryFileImpl(@Value("${file.name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(product.getName());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public List<Product> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split("#"))// разбил строки по #
                    .map(array -> new Product(array[0]))// превратил массив строк в объект
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }
}
