package ru.gb.cart_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.cart_service.model.Cart;


import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
