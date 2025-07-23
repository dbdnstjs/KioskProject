package org.example.challenge.lv2;

import java.math.BigDecimal;

// 주문한 항목의 이름, 가격, 설명
public enum CartItem {
    BURGER("ShackBurger","6.9","토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
    DRINKS("ShackDrink","5.9","토마토, 양상추, 쉑소스가 들어간 음료"),
    DESSERTS("ShackDessert","4.9","토마토, 양상추, 쉑소스가 들어간 디저트");

    private final String name,price,description;

    CartItem(String name,String price,String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getPrice(){
        return new BigDecimal(price);
    }

    public String getDescription(){
        return description;
    }
}
