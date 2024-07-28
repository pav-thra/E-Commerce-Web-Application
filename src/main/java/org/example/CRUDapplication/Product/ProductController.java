package org.example.CRUDapplication.Product;

import org.example.CRUDapplication.Product.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

//tells spring boot to act like a controller : use annotations
@RestController

//tells where to go
@RequestMapping("/products")

public class ProductController
{
    //Create, Read, Update, Delete
    //Post, Get, Set, Delete : Type of request methods

    //use the product repo to complete the controller
    //inject Product repo here
    @Autowired
    private ProductRepository productRepository;


    @GetMapping
    public ResponseEntity<List<Product>> getProducts()
    {
        return ResponseEntity.ok(productRepository.findAll());

        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        //.status() - used to set the HTTP status
        //response body - here it returns an empty list as the body of the response
        //return ResponseEntity.ok().build(); - Creates a ResponseEntity with a 200 OK status and no body.

    }
}
