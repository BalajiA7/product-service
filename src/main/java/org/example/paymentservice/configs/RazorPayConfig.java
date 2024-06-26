package org.example.paymentservice.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {

    @Bean
    public RazorpayClient getRazorPayClient() throws RazorpayException {
        //    @Value("${razorpay.apiSecret}")
        String apiSecret = "12345678";
        //    @Value("${razorpay.apikey}")
        String apiKey = "123456";
        return new RazorpayClient(apiKey, apiSecret);
    }
}
