package org.example.challenge.lv2;

import java.util.ArrayList;
import java.util.List;

// 메뉴 카테고리 이름과 해당 항목들을 포함하는 클래스
public class Menu {
    String num, name;
    List<MenuItem> menuItems = new ArrayList<>();

    Menu(String num, String name) {
        this.num = num;
        this.name = name;
    }

    void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    List<MenuItem> getMenuItems(){
        return menuItems;
    }

    String getName() {
        return name;
    }

    String getNum() {
        return num;
    }


}
