package org.example.challenge.lv2;

import java.util.ArrayList;
import java.util.List;

// 기본값들을 지정하고 Kiosk를 실행하는 메인 클래스
public class Lv2Kiosk {
    public static void main(String[] args) {
        final List<Menu> menus = new ArrayList<>();
        Menu burger = new Menu("1", "Burgers");
        Menu drink = new Menu("2", "Drinks");
        Menu dessert = new Menu("3", "Desserts");
        burger.addMenuItem(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Cheeseburger", "6.9 ", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        drink.addMenuItem(new MenuItem("ShackDrink", "2.9", "토마토, 양상추, 쉑소스가 들어간 음료"));
        drink.addMenuItem(new MenuItem("SmokeDrink", "4.9", "베이컨, 체리 페퍼에 쉑소스가 들어간 음료"));

        dessert.addMenuItem(new MenuItem("Cheese", "3.9", "평범한 치즈"));
        dessert.addMenuItem(new MenuItem("Ham", "2.4", "평범한 햄"));

        menus.add(burger);
        menus.add(drink);
        menus.add(dessert);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
