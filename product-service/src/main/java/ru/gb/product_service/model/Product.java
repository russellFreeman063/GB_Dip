package ru.gb.product_service.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantity;

}
