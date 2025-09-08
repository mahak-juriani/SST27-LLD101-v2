package com.example.payments;
import java.util.Objects;

public class FastPayAdapter implements PaymentGateway{
    private final FastPayClient client;

    public FastPayAdapter(FastPayClient client){
        this.client = Objects.requireNonNull(client);
    }

    @Override
    public String charge(String customerId, int amountCents){
        PaymentGateway.requireValid(customerId, amountCents);
        return client.payNow(customerId, amountCents);
    }
}
