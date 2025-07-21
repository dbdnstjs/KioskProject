package org.example.challenge.lv1;

import java.util.ArrayList;
import java.util.List;

//메뉴 담기, 계산, 출력
public class Cart {
    private final List<CartItem> cartItems = new ArrayList<>();

    public void addCartIem(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

}
