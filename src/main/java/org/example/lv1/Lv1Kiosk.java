package org.example.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lv1Kiosk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("[ SHAKESHACK MENU ]\n" +
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
                    "0. 종료      | 종료\n");
            int num = sc.nextInt();
            if(num==1) System.out.println("ShackBurger");
            else if(num==2) System.out.println("SmokeShack");
            else if(num==3) System.out.println("Cheeseburger");
            else if(num==4) System.out.println("Hamburger");
            else if(num==0){
                System.out.println("프로그램을 종료합니다.");
                break;
            } else throw new IllegalArgumentException("오류 : 0~4 사이의 숫자를 입력해 주세요.");
        }
    }
}