package org.example.challenge.lv1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//메뉴 담기, 계산, 출력
public class Cart {
    private final List<CartItem> cartItems = new ArrayList<>();

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public BigDecimal sumCart() {
        BigDecimal sum = BigDecimal.ZERO;

        for (CartItem item : cartItems) {
            sum = sum.add(item.getPrice());
        }
        return sum;
    }

    public void clearCart(){
        cartItems.clear();
    }
}
