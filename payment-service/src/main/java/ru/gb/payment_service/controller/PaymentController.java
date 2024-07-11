package ru.gb.payment_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.payment_service.model.Payment;
import ru.gb.payment_service.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.addPayment(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        Payment updatedPayment = paymentService.updatePayment(id, paymentDetails);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}