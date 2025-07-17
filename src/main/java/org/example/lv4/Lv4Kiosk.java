package org.example.lv4;

public class Lv4Kiosk {
    public static void main(String[] args) {
        // Menu 객체 생성을 통해 이름 설정
        Menu menu = new Menu("[ SHAKESHACK MENU ]");
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        menu.addItem(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.addItem(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.addItem(new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.addItem(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
