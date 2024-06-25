package com.rajibul.SpringSecurityApp1.service;

import com.rajibul.SpringSecurityApp1.models.Product;

import java.util.List;

public interface ProductService {
    public Product newProduct(Product p);
    public List<Product> getAllProduct();
    public Product findProduct(Integer id);
    public Product updateProductDetails(Product p);
    public String deleteProduct(Integer id);
}
