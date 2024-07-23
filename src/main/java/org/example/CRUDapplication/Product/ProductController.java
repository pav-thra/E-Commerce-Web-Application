package org.example.CRUDapplication.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

//tells spring boot to act like a controller : use annotations
@RestController

//tells where to go
@RequestMapping("/products")

public class ProductController
{
    //Create, Read, Update, Delete
    //Post, Get, Set, Delete : Type of request methods

    @GetMapping
    public ResponseEntity getProduct()
    {
        System.out.println("Get product method");
        return ResponseEntity.status(HttpStatus.OK).body(Collections.emptyList());
    }
}
