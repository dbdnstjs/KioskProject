package org.example.challenge.lv2;

import java.math.BigDecimal;

public class MenuItem {
    private final String name, price, description;

    MenuItem(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return new BigDecimal(price);
    }

    public String getDescription() {
        return description;
    }
}
