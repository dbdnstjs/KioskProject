package org.example.challenge.lv2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

//add Stream, Lambda
// 버거, 음료, 디저트를 출력하고 사용자 입력을 처리하는 키오스크 클래스
// 할인률 추가 및 stream을 이용하여 특정 메뉴 빼기 및 출력 (캡슐화)
public class Kiosk {
    private final List<Menu> menus;
    private final Cart cart = new Cart();

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

                if (!cart.getCartItems().isEmpty()) {
                    System.out.println("""
                            [ ORDER MENU ]
                            4. Orders       | 장바구니를 확인 후 주문합니다.
                            5. Cancel       | 진행중인 주문을 취소합니다.
                            """);
                }

                int num1 = sc.nextInt(); // select burger drink dessert exit
                sc.nextLine();

                //null point exception
                if (num1 == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if ((num1 == 4 || num1 == 5) && !cart.getCartItems().isEmpty()) {
                    if (num1 == 5) {
                        cart.clearCart();
                        continue;
                    } else {
                        System.out.printf("아래와 같이 주문 하시겠습니까?%n%n[ Orders ]%n");
                        for (CartItem item : cart.getCartItems()) {
                            System.out.printf("선택한 메뉴: %s | W%s | %s %n", item.getName(), item.getPrice(), item.getDescription());
                        }
                        System.out.printf("[ Total ]%n W %s%n%n1. 주문      2. 메뉴판%n", cart.sumCart());
                        int num2 = sc.nextInt();
                        sc.nextLine();
                        if (num2 == 1) {
                            System.out.println("할인 정보를 입력해주세요.");
                            int cnt = 0;
                            for (SaleItem item : SaleItem.values()) {
                                System.out.printf("%d. %-11s : %s%n", ++cnt, item.getName(), item.getPrice());
                            }

                            int num3 = sc.nextInt();
                            sc.nextLine();
                            if(num3>0&&num3<5){
                                SaleItem[] item = SaleItem.values();
                                BigDecimal total,discountRate,discountPercent;
                                discountPercent = new BigDecimal(item[num3-1].getPrice());
                                discountRate = BigDecimal.ONE.subtract(discountPercent.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
                                total = cart.sumCart().multiply(discountRate.setScale(2,RoundingMode.HALF_UP));
                                System.out.printf("주문이 완료되었습니다. 금액은 W %s 입니다.%n",total);
                                cart.clearCart();
                            }else{
                                throw new IllegalArgumentException("오류 : 1~4번 숫자를 입력해주세요.");
                            }
                            continue;
                        } else if (num2 == 2) {
                            continue;
                        } else {
                            throw new IllegalArgumentException("오류 : 1~2번 숫자를 입력해주세요.");
                        }
                    }
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
                            cart.addCartItem(new CartItem(category.getName(), category.getPrice(), category.getDescription()));
                            System.out.printf("%s 이 장바구니에 추가되었습니다.%n", category.getName());
                            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                            break;
                        } else if (num3 == 2) {
                            System.out.println("취소되었습니다.");
                        } else {
                            throw new IllegalArgumentException("오류 : 1~2번 숫자를 입력해주세요.");
                        }
                    } else if (num2 == 0) {
                        break;
                    } else {
                        throw new IllegalArgumentException("오류 : 0~" + menuItems.size() + "번 숫자를 입력해주세요.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
