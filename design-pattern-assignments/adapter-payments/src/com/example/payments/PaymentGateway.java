package com.example.payments;
import java.util.Objects;
public interface PaymentGateway {
    String charge(String customerId, int amountCents);

    static void requireValid(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");
        if (customerId.isBlank()) throw new IllegalArgumentException("customerId blank");
        if (amountCents <= 0) throw new IllegalArgumentException("amountCents must be > 0");
    }
}
