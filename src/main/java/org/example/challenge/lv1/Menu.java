package org.example.challenge.lv1;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    private final String num, name;
    private final List<MenuItem> menuItems = new ArrayList<>();
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

