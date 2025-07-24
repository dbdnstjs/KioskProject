package org.example.challenge.lv2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

// 장바구니 아이템을 추가하고, 총합을 계산하며, 전체 비우기 기능을 제공하는 클래스
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    void addCartItem(CartItem cartItem){
        cartItems.add(cartItem);
    }

    List<CartItem> getCartItems(){
        return cartItems;
    }

    void setCartItems(List<CartItem> cartItems){
        this.cartItems = cartItems;
    }

    BigDecimal sumCart(){
        BigDecimal sum = BigDecimal.ZERO;
        for(CartItem item : cartItems) sum = sum.add(item.getPrice());
        //소수점 2번쨰 자리 반올림
        return sum.setScale(2, RoundingMode.HALF_UP);
    }

    void clearCart(){
        cartItems.clear();
    }
}
