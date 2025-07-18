package org.example.lv4;

import java.util.ArrayList;
import java.util.List;

public class Lv4Kiosk {
    public static void main(String[] args) {
        // Menu 객체 생성을 통해 이름 설정
        List<Menu> menu = new ArrayList<>();
        menu.add(new Menu("1", "Burgers"));
        menu.add(new Menu("2", "Drinks"));
        menu.add(new Menu("3", "Desserts"));
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));
        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menu,menuItems);
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
