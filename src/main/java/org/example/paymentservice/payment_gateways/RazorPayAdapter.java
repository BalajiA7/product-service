package org.example.paymentservice.payment_gateways;
import com.razorpay.PaymentLink;
import org.example.paymentservice.configs.RazorPayConfig;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RazorPayAdapter implements PaymentGateWayAdapter{
    private final RazorpayClient razorPayClient;

    @Autowired
    public RazorPayAdapter(RazorpayClient razorPayConfig) {
        this.razorPayClient = razorPayConfig;
    }

    @Override
    public String createPaymentLink(long orderId, long amount) throws RazorpayException {
        //Payment Link
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount); //199.99 => 19999
        paymentLinkRequest.put("currency","INR");
        //paymentLinkRequest.put("accept_partial",true);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1719585639);
        paymentLinkRequest.put("reference_id",String.valueOf(orderId)); //Is the order id at the client end
        paymentLinkRequest.put("description","Payment for product");

        // Customer
        JSONObject customer = new JSONObject();
        customer.put("name","Balaji A");
        customer.put("contact","+919000090000");
        customer.put("email","balab8271@gmail.com");
        paymentLinkRequest.put("customer",customer);

        // Notification
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);

        // Additional Notes
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorPayClient.paymentLink.create(paymentLinkRequest);
        return payment.get("short_url");
    }
}
