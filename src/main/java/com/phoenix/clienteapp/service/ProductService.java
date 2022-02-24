package com.phoenix.clienteapp.service;

import com.phoenix.clienteapp.DAO.productDAO.ProductDataAccess;

import com.phoenix.clienteapp.models.Product;
import com.phoenix.clienteapp.DAO.productDAO.ProductDataAccess;
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
    private ProductDataAccess dataAccess;
    
    public ProductService(){
        dataAccess = new ProductDataAccess();
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
        } else {
            return new ArrayList<>(products.subList(0, size));
        }

    }

    public void changeStateProduct(int id) {
        ProductDataAccess prodt = new ProductDataAccess();
        prodt.deleteLogicProduct(id);
    }

    public void saveProduct(Product selectedProduct) {
        dataAccess.save(selectedProduct);
    }

    public void updateProduct(Product selectedProduct) {
        dataAccess.updateProduct(selectedProduct.getId(), selectedProduct);
    }
}
