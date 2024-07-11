package ru.gb.payment_service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.payment_service.exception.ResourceNotFoundException;
import ru.gb.payment_service.model.Payment;
import ru.gb.payment_service.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id " + id));
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id " + id));
        payment.setOrderId(paymentDetails.getOrderId());
        payment.setAmount(paymentDetails.getAmount());
        payment.setStatus(paymentDetails.getStatus());
        payment.setPaymentDate(paymentDetails.getPaymentDate());
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id " + id));
        paymentRepository.delete(payment);
    }
}