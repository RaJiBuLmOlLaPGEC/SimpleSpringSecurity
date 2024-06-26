package com.rajibul.SpringSecurityApp1.controller;

import com.rajibul.SpringSecurityApp1.models.Product;
import com.rajibul.SpringSecurityApp1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class AdminController {
    @Autowired
    private ProductService  productService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Product> addProduct(@RequestBody Product newProdect){
        return new ResponseEntity<>(productService.newProduct(newProdect), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Product> updateProduct(@RequestBody Product newProdect){
        return new ResponseEntity<>(productService.updateProductDetails(newProdect),HttpStatus.CREATED);
    }

    @DeleteMapping ("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productService.findProduct(id), HttpStatus.CREATED);
    }
    @GetMapping("")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.CREATED);
    }
}
