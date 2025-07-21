package org.example.challenge.lv1;

import java.util.ArrayList;
import java.util.List;

//- 장바구니에 메뉴 담기
//- 수량/가격/총합 출력- 주문 기능
//인터페이스 또는 상속을 활용하여 코드의 재사용성을 높일 수 있는가?
//예외 처리(try-catch-finally)를 통해 오류를 적절히 처리할 수 있는가?
//제네릭을 활용하여 재사용 가능 클래스를 설계하고 람다식을 활용한 함수형 인터페이스를 구현할 수 있는가?
//스트림 API를 활용하여 데이터를 필터링, 변환할 수 있는가?
public class Lv1Kiosk {
    public static void main(String[] args) {
        // Menu 객체 생성을 통해 이름 설정
        final List<Menu> menu = new ArrayList<>();
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        Menu menuitem = new Menu("1","Burgers");
        menuitem.addMenuItem(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuitem.addMenuItem(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuitem.addMenuItem(new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuitem.addMenuItem(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));
        menu.add(menuitem);

        menu.add(new Menu("2", "Drinks"));
        menu.add(new Menu("3", "Desserts"));
        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menu);
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
