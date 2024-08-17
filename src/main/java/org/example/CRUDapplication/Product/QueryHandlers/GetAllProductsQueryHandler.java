package org.example.CRUDapplication.Product.QueryHandlers;

import org.example.CRUDapplication.Product.Model.Product;
import org.example.CRUDapplication.Product.ProductRepository;
import org.example.CRUDapplication.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandler implements Query <Void, List<Product>>
//here input is void and output is a list of products
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<List<Product>> execute(Void input)
    {
        return ResponseEntity.ok(productRepository.findAll());
    }
}
