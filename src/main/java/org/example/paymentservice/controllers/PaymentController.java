package org.example.paymentservice.controllers;

import org.example.paymentservice.dtos.CreatePaymentLinkRequestDto;
import org.example.paymentservice.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createPaymentLink(CreatePaymentLinkRequestDto requestDto) {
        try {
            String URL = this.paymentService.createPaymentLink(requestDto.getOrderId(), requestDto.getAmount());
            return new ResponseEntity<>(URL, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
