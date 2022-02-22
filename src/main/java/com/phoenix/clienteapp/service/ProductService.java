package com.phoenix.clienteapp.service;

import com.phoenix.clienteapp.productDAO.ProductDataAccess;

import com.phoenix.clienteapp.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ProductService {

    private List<Product> products;

    
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Bamboo Watch", "Product Description"));
        products.add(new Product(2, "Black Watch", "Product Description"));
        products.add(new Product(3, "Blue Band", "Product Description"));
        products.add(new Product(4, "Blue T-Shirt", "Product Description"));
        products.add(new Product(5, "Bracelet", "Product Description"));
    }
    
    
    public List<Product> getProducts() {
        ProductDataAccess prodt = new ProductDataAccess();
        return prodt.getProducts();
    }

    public List<Product> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Product> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(products.subList(0, size));
        }

    }
}