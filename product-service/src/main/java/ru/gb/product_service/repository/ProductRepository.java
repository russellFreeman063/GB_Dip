package ru.gb.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.product_service.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
