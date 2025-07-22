package org.example.challenge.lv1;

import java.math.BigDecimal;

public class CartItem {
    private final String name, description;
    private final BigDecimal price;

    public CartItem(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
