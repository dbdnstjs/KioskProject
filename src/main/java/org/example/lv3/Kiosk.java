package org.example.lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.printf("%d. %-12s | W%-5s | %s\n", i + 1, item.getName(), item.getPrice(), item.getDescription());
            }
            System.out.printf("%d. %-11s | %-5s \n", 0, "종료", "종료");

            int num = sc.nextInt();
            if (num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (num > 0 && num < 5) {
                MenuItem x = menuItems.get(num - 1);
                System.out.printf("선택한 메뉴 :  %-12s | W%-5s | %s\n", x.getName(), x.getPrice(), x.getDescription());
            } else {
                throw new IllegalArgumentException("오류 : 0~4 사이의 숫자를 입력해 주세요.");
            }
        }
    }
}
