package ru.gb.cart_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.cart_service.model.Cart;
import ru.gb.cart_service.service.CartService;



@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.save(cart));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.findByUserId(userId));
    }
}