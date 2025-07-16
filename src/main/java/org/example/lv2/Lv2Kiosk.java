package org.example.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lv2Kiosk {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        menuItems.add(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.printf("%d. %-15s | W%-5s | %s\n", i + 1, item.getName(), item.getPrice(), item.getDescription());
            }
            System.out.printf("%d. %-14s | %-5s \n", 0, "종료", "종료");

            int num = sc.nextInt();
            if (num==0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else if(num>0&&num<5){
                MenuItem x = menuItems.get(num-1);
                System.out.printf("선택한 메뉴 : %s, %s, %s\n", x.getName(), x.getPrice(), x.getDescription());
            }else{
                throw new IllegalArgumentException("오류 : 0~4 사이의 숫자를 입력해 주세요.");
            }
        }
    }
}

