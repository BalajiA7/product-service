package org.example.paymentservice.services;

import org.example.paymentservice.payment_gateways.PaymentGateWayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    PaymentGateWayAdapter paymentGateWayAdapter;

    @Autowired
    public PaymentServiceImpl(@Qualifier("stripePGAdapter") PaymentGateWayAdapter paymentGateWayAdapter) {
        this.paymentGateWayAdapter = paymentGateWayAdapter;
    }

    @Override
    public String createPaymentLink(long orderId, long amount) throws Exception {
        //TODO Fetch order and payment related details and call the payment link
        return paymentGateWayAdapter.createPaymentLink(orderId, amount);
    }

}
