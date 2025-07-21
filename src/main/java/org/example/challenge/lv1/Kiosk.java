package org.example.challenge.lv1;

import java.util.List;
import java.util.Scanner;

// 장바구니에 물건이 들어 있으면 아래와 같이 [ ORDER MENU ] 가 추가로 출력됩니다.
// 만약에 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않습니다.
// 미출력일 때 4,5 번을 누르면 예외를 던저줘야 합니다.
//
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

            /*
            if cart is not empty
            System.out.println("""
                            [ ORDER MENU ]
                            4. Orders       | 장바구니를 확인 후 주문합니다.
                            5. Cancel       | 진행중인 주문을 취소합니다.
                            """);
            */

            int num1 = sc.nextInt();
            sc.nextLine(); //버퍼 초기화

            if (num1 == 0) {
                System.out.println("프로그램을 종료합니다.");
                sc.close();
                return;
            }

            while (true) {
                List<MenuItem> menuItems = menu.get(num1 - 1).getMenuItems();
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
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인        2. 취소");
                        int num3 = sc.nextInt();
                        if (num3 == 1) {
                            //call addCart
                            System.out.printf("%s 이 장바구니에 추가되었습니다.\n", category.getName());
                        } else if (num3 == 0) {
                            System.out.println("취소되었습니다.");
                        } else {
                            throw new IllegalArgumentException("오류 : 0~1번 숫자를 입력해주세요.");
                        }
                    } else if (num2 == 0) {
                        break;
                    } else {
                        throw new IllegalArgumentException("오류 : 0~4번 숫자를 입력해주세요.");
                    }
                } else if (num1 == 2 || num1 == 3) {
                    System.out.println("현재 판매하지 않는 품목입니다.");
                    break;
                } else if (num1 == 4 || num1 == 5) {
                    //if cart is empty call exception
                    if(num1==4){
                        System.out.printf("아래와 같이 주문 하시겠습니까?\n\n[ Orders ]\n");
                        //call cart
                        //System.out.printf("[ Total ]\n W %s\n\n1. 주문      2. 메뉴판\n",);
                        int num2 = sc.nextInt();
                        sc.nextLine();
                        if(num2==1){
                            //System.out.printf("주문이 완료되었습니다. 금액은 W %s 입니다.",);
                            //init cart
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("오류 : 0~3번 숫자를 입력해주세요.");
                }
            }
        }
    }
}

