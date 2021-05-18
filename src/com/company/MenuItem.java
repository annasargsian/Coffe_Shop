package com.company;

import java.util.Objects;

public class MenuItem {
    private String nameOfItem;
    private String type;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(menuItem.price, price) == 0 && nameOfItem.equals(menuItem.nameOfItem) && type.equals(menuItem.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfItem, type, price);
    }

    public String getNameOfItem() {

        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {

        this.nameOfItem = nameOfItem;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "nameOfItem='" + nameOfItem + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
