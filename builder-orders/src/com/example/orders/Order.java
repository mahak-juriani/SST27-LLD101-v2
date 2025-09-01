package com.example.orders;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent; // 0..100 expected, but not enforced
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        List<OrderLine> copy = new ArrayList<>(builder.lines.size());
        for (OrderLine l : builder.lines) {
            // assumes OrderLine has getters & a (sku, qty, price) ctor
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        this.lines = Collections.unmodifiableList(copy);
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    // public Order(String id, String customerEmail, Integer discountPercent) {
    // this(id, customerEmail);
    // this.discountPercent = discountPercent;
    // }

    // public void addLine(OrderLine line) { lines.add(line); }
    // public void setDiscountPercent(Integer discountPercent) {
    // this.discountPercent = discountPercent; }
    // public void setExpedited(boolean expedited) { this.expedited = expedited; }
    // public void setNotes(String notes) { this.notes = notes; }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public boolean isExpedited() {
        return expedited;
    }

    public String getNotes() {
        return notes;
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines)
            sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null)
            return base;
        return base - (base * discountPercent / 100);
    }

    public static class Builder {
        private static final Pattern EMAIL_RX = Pattern
                .compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();;

        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            if (id == null)
                throw new Error("id required");
            if (customerEmail == null)
                throw new Error("customerEmail required");
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line == null)
                throw new Error("line cannot be null");
            lines.add(line);
            return this;
        }

        public Builder discountPercent(int discountPercent) {
            if (discountPercent < 0 || discountPercent > 100) {
                throw new Error("Discount range from 0...100");
            }

            this.discountPercent = discountPercent;
            return this;
        }

        public Builder setExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (id == null) {
                throw new Error("id must not be null");
            }
            if (customerEmail == null) {
                throw new Error("customer email should not be null");
            }
            if (!EMAIL_RX.matcher(customerEmail).matches()) {
                throw new Error("customerEmail is invalid: " + customerEmail);
            }
            if (lines == null) {
                throw new Error("Order must have at least one line");
            }
            if (discountPercent != null &&
                    (discountPercent < 0 || discountPercent > 100)) {
                throw new Error("discountPercent must be in range 0..100");
            }
            return new Order(this);
        }
    }
}
