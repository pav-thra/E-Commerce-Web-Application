package org.example.CRUDapplication.Product.Model;

import jakarta.persistence.*;
import lombok.Data;

//annotate this object so that Java knows to map it to the database
@Entity

//to automatically generate getters and setters we use Lombok
@Data

//which table to map to explicitly
@Table(name = "product")

public class Product
{
    //Using wrapper classes
    @Id //tells this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generates the id when we add product to a database and will auto increment
    @Column(name = "id") //tells which column to map to in the Product table
    private Integer id; //this is the primary key

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private int quantity;
}
