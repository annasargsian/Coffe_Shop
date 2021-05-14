package com.company;

public class CoffeeShop {
    private String nameOfCoffeeShop;
    private MenuItem[] orders = new MenuItem[100];
    private MenuItem[] menu = new MenuItem[100];
    private int currentElementOfOrders = 0;

    public String addOrder(MenuItem order) {

        boolean check = false;
        for (int i = 0; i < menu.length; i++) {
            if (order.equals(menu[i])) {
                check = true;
                orders[currentElementOfOrders] = order;
                currentElementOfOrders++;
                break;
            }
        }
        if (check) {
            return "Ok";
        } else {
            return "This item currently unavailable";
        }

    }

    public String fulFillOrder(MenuItem order){
        if(currentElementOfOrders <= 0){
            return "All orders have been fulfilled!";
        } else {
            for (int i = 0; i < orders.length; i++) {
                if(order.equals(orders[i])){
                    orders[i] = null;
                    if(i != currentElementOfOrders){
                        for (int j = i + 1; j < currentElementOfOrders; j++) {
                            orders[j - 1] = orders[j];
                        }
                    }
                    currentElementOfOrders--;

                }
            }
            return "Ok";
        }
    }


    public String getNameOfCoffeeShop() {
        return nameOfCoffeeShop;
    }

    public void setNameOfCoffeeShop(String nameOfCoffeeShop) {
        this.nameOfCoffeeShop = nameOfCoffeeShop;
    }

    public MenuItem[] getOrders() {
        return orders;
    }

    public void setOrders(MenuItem[] orders) {
        this.orders = orders;
    }

    public MenuItem[] getMenu() {
        return menu;
    }

    public void setMenu(MenuItem[] menu) {
        this.menu = menu;
    }
}
