package org.example.CRUDapplication.Product;

import org.example.CRUDapplication.Product.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //to get specific product using its id
    //means when this mapping in pinged add the id you are looking for
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Integer id)
    //means whatever endpoint is there in get mapping pass it into the function
    //make sure getMapping id and path variable id var name is same
    {
        return ResponseEntity.ok(productRepository.findById(id));
        //optional product: means like what if it is not there then?
    }

    //accept product as JSON, convert it to an actual product and save it to database
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product)
    {
        //to tell Spring Boot, product comes in the body of the request tell it @request body
        //call product repo and built in save method to save product
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product)
    {
        // which product to update
        //using ID appear or by passing ID

        product.setId(id);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id)
    {
        // find the product using id
        Product product = productRepository.findById(id).get();
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
