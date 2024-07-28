package org.example.CRUDapplication.Product;

import org.example.CRUDapplication.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//it connects MySQL to the Java Code
//<...> indicates it is a JPA repository for the Product wih primary key of type integer
public interface ProductRepository extends JpaRepository<Product, Integer>
{
    //Jpa repo writes query for you in the background when you call certain methods

}
