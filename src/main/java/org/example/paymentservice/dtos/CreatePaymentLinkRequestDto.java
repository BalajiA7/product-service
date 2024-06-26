package org.example.paymentservice.dtos;

import lombok.Data;

@Data
public class CreatePaymentLinkRequestDto {
    private long orderId;
    //TODO not implemented order service, so fetching amount directly from request
    private long amount;
}
