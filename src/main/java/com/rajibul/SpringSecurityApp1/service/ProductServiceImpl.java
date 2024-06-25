package com.rajibul.SpringSecurityApp1.service;

import com.rajibul.SpringSecurityApp1.models.Product;
import com.rajibul.SpringSecurityApp1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product newProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProductDetails(Product p) {
        Product p1=productRepository.findById(p.getProductId()).get();
        p1=p;
        return productRepository.save(p);
    }

    @Override
    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "Delete Successful!";
    }
}
