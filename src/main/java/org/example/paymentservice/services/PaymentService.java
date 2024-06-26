package org.example.paymentservice.services;

import org.springframework.stereotype.Service;

public interface PaymentService {
    public String createPaymentLink(long orderId, long amount) throws Exception;
}
