package org.example.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // MenuItem 클래스를 List로 관리
    List<MenuItem> menuitems = new ArrayList<>();

    public void addItem(MenuItem item) {
        this.menuitems.add(item);
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void printItem() {
        int cnt = 0;
        System.out.println("[ SHAKE-SHACK MENU ]");
        for (MenuItem x : menuitems){
            System.out.printf("%d. %-12s | W%-5s | %s\n", ++cnt, x.name, x.price, x.description);
        }
    }

    // List를 리턴하는 함수
    public List<MenuItem> getMenuitems(){
        return this.menuitems;
    }

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.

    public void printcategory() {
        int cnt = 0;
        System.out.println("[ MAIN MENU ]");
        for (MenuItem x : menuitems){
            System.out.printf("%d. %-12s | W%-5s | %s\n", ++cnt, x.name, x.price, x.description);
        }
    }
}
