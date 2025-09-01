package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        // Order o = new Order(id, email, discount);
        // if (lines != null) for (OrderLine l : lines) o.addLine(l);
        // o.setExpedited(expedited);
        // o.setNotes(notes);
        // return o;

        Order.Builder builder = new Order.Builder(id, email);

        if(lines!=null){
            throw new Error("Order must have atleast one line.");
        }
        for(OrderLine l: lines){
            builder.addLine(l);
        }

        if(discount!=null){
            builder.discountPercent(discount);
        }
        builder.setExpedited(expedited);

        if(notes!=null){
            builder.setNotes(notes);
        }

        return builder.build();
    }
}
