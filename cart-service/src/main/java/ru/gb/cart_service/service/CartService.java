package ru.gb.cart_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.cart_service.model.Cart;
import ru.gb.cart_service.repository.CartRepository;


@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart findByUserId(Long userId) {
        return cartRepository.findByUserId(userId).orElse(null);
    }
}