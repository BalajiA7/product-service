package org.example.paymentservice.payment_gateways;

public interface PaymentGateWayAdapter {
    public String createPaymentLink(long orderId, long amount) throws Exception;
}
