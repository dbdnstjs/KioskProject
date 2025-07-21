package org.example.lv5;

import java.util.ArrayList;
import java.util.List;

//메뉴 클래스가 메뉴아이템을 관리할수 있게 변경
//메뉴가 메뉴아이템 관리 -> 특정 매뉴(상세품목 = 버거의 종류, 피자의 종류)
public class Menu {
    private String num, name;
    private List<MenuItem> menuItems = new ArrayList<>();
    // MenuItem 클래스를 List로 관리
    public Menu(String num, String name) {
        this.num = num;
        this.name = name;
    }

    public void addMenuItem(MenuItem menuitem){
        menuItems.add(menuitem);
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems(){
        return menuItems;
    }
    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
