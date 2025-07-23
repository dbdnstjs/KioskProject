package org.example.challenge.lv2;

import java.util.List;
import java.util.Scanner;

// 버거, 음료, 디저트를 출력하고 사용자 입력을 처리하는 키오스크 클래스
// 할인률 추가 및 stream을 이용하여 특정 메뉴 빼기 및 출력 (캡슐화)
public class Kiosk {
    List<Menu> menus;
    Cart cart = new Cart();

    Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    void start() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                //print main menu
                System.out.println("[ MAIN MENU ]");
                for (Menu category : menus) {
                    System.out.printf("%s. %s%n", category.getNum(), category.getName());
                }
                System.out.printf("%d. %-11s | %-5s %n", 0, "종료", "종료");

                //if cartItem empty

                int num1 = sc.nextInt(); // select burger drink dessert exit
                sc.nextLine();

                //null point exception
                if (num1 == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if ((num1 == 4 || num1 == 5)) {
                    //4. order menu 5. cancel
                    break;
                }

                while (true) {
                    if (num1 == 1) System.out.println("[ BURGERS MENU ]");
                    else if (num1 == 2) System.out.println("[ DRINK MENU ]");
                    else if (num1 == 3) System.out.println("[ DESSERT MENU ]");
                    else throw new IllegalArgumentException("오류 : 0~4번 숫자를 입력해주세요.");

                    List<MenuItem> menuItems = menus.get(num1 - 1).getMenuItems();
                    int cnt = 0;
                    for (MenuItem category : menuItems) {
                        System.out.printf("%d. %-12s | W%-5s | %s%n", ++cnt, category.getName(), category.getPrice(), category.getDescription());
                    }
                    System.out.printf("%d. %s%n", 0, "뒤로가기");

                    int num2 = sc.nextInt(); // select menu
                    sc.nextLine();

                    if (num2 > 0 && num2 <= menuItems.size()) {
                        MenuItem category = menuItems.get(num2 - 1);
                        System.out.printf("선택한 메뉴: %s | W%s | %s %n", category.getName(), category.getPrice(), category.getDescription());
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인        2. 취소");
                        int num3 = sc.nextInt();
                        sc.nextLine();
                        if (num3 == 1) {
                            //add item
                            System.out.printf("%s 이 장바구니에 추가되었습니다.%n", category.getName());
                            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                        } else if (num3 == 2) {
                            System.out.println("취소되었습니다.");
                        }else{
                            throw new IllegalArgumentException("오류 : 1~2번 숫자를 입력해주세요.");
                        }

                    } else if (num2 == 0) {
                        break;
                    } else {
                        throw new IllegalArgumentException("오류 : 0~"+menuItems.size()+"번 숫자를 입력해주세요.");
                    }

                    break;
                }

                break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
