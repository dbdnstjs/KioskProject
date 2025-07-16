package org.example.lv2;

public class MenuItem {
    private final String name, price, description;

    public MenuItem(String name,String price,String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }

}
