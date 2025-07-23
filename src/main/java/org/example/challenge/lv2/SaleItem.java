package org.example.challenge.lv2;

//할인대상, 할인률
public enum SaleItem {
    VETERAN("국가유공자", "10"),
    SOLDIER("군인", "5"),
    STUDENT("학생", "3"),
    GENERAL("일반", "0");

    private final String name, price;

    SaleItem(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
