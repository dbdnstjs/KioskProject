package org.example.lv5;

public class MenuItem {
    // 이름, 가격, 설명 필드 선언하여 관리
    private final String name, price, description;

    public MenuItem(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
}
