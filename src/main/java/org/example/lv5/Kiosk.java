package org.example.lv5;

import java.util.List;
import java.util.Scanner;

//키오스크가 메뉴클레스 관리 -> 메뉴 아이템(버거,음료,간식 등)
public class Kiosk {
    private final List<Menu> menu;

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
    }

    public void start() {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 반복문 시작
        while (true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (Menu category : menu) {
                System.out.printf("%s. %s\n", category.getNum(), category.getName());
            }
            // 숫자 입력 받기
            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
            System.out.printf("%d. %-11s | %-5s \n", 0, "종료", "종료");
            int num1 = sc.nextInt();
            sc.nextLine(); //버퍼 초기화

            if (num1 == 0) {
                System.out.println("프로그램을 종료합니다.");
                sc.close();
                return;
            }

            while (true) {
                List<MenuItem> menuItems = menu.get(num1-1).getMenuItems();
                if (num1 == 1) {
                    // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                    System.out.println("[ BURGERS MENU ]");
                    int cnt = 0;
                    for (MenuItem category : menuItems) {
                        System.out.printf("%d. %-12s | W%-5s | %s\n", ++cnt, category.getName(), category.getPrice(), category.getDescription());
                    }
                    System.out.printf("%d. %s\n", 0, "뒤로가기");
                    // 숫자 입력 받기
                    int num2 = sc.nextInt();
                    sc.nextLine();
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                    if (num2 > 0 && num2 < 5) {
                        // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                        MenuItem category = menuItems.get(num2 - 1);
                        System.out.printf("선택한 메뉴: %s | W%s | %s \n", category.getName(), category.getPrice(), category.getDescription());
                    } else if (num2 == 0) {
                        break;
                    } else {
                        throw new IllegalArgumentException("오류 : 0~4번 숫자를 입력해주세요.");
                    }
                }else if (num1 == 2 || num1 == 3) {
                    System.out.println("현재 판매하지 않는 품목입니다.");
                    break;
                } else {
                    throw new IllegalArgumentException("오류 : 0~3번 숫자를 입력해주세요.");
                }
            }
        }
    }
}
