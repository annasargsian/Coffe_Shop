package com.company;

public class CoffeeShop {
    private String nameOfCoffeeShop;
    private MenuItem[] orders = new MenuItem[100];
    private MenuItem[] menu = new MenuItem[100];
    private int currentElementOfOrders = 0;
    private double currentPriceOfOrder = 0;

    public String addOrder(MenuItem order) {

        boolean check = false;
        for (int i = 0; i < menu.length; i++) {
            if (order.equals(menu[i])) {
                check = true;
                orders[currentElementOfOrders] = order;
                currentElementOfOrders++;
                currentPriceOfOrder += order.getPrice();
                break;
            }
        }
        if (check) {
            return "Ok";
        } else {
            return "This item currently unavailable";
        }

    }

    public String fulFillOrder(MenuItem order) {
        if (currentElementOfOrders <= 0) {
            return "All orders have been fulfilled!";
        } else {
            for (int i = 0; i < orders.length; i++) {
                if (order.equals(orders[i])) {
                    orders[i] = null;
                    if (i != currentElementOfOrders) {
                        for (int j = i + 1; j < currentElementOfOrders; j++) {
                            orders[j - 1] = orders[j];
                        }
                    }
                    currentElementOfOrders--;

                }
            }
            return "Everything is good";
        }
    }

    public String[] listOfOrders() {
        String[] listOfOrders = new String[orders.length];
        if (currentElementOfOrders > 0) {
            for (int i = 0; i < orders.length; i++) {
                if (orders[i] == null) {
                    break;
                }
                listOfOrders[i] = orders[i].getNameOfItem();
            }
            return listOfOrders;
        } else {
            return new String[0];
        }
    }

    public void dueAmount() {
        System.out.println("The total amount due for the orders " + currentPriceOfOrder);
    }

    public void cheapestItem(MenuItem[] orders) {
        double cheapestItem = orders[0].getPrice();
        for (int i = 1; i < orders.length; i++) {
            if (orders[i].getPrice() < cheapestItem) {
                cheapestItem = orders[i].getPrice();
            }
        }
        System.out.println("The cheapest price of item is " + cheapestItem);
    }

    public String[] drinksOnly(MenuItem[] orders) {
        return foodOrDrinkOnly(orders, "drink");
    }

    public String[] foodOnly(MenuItem[] orders) {
        return foodOrDrinkOnly(orders, "food");
    }

    public String[] foodOrDrinkOnly(MenuItem[] orders, String type) {
        int countFood = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getType().equals(type)) {
                countFood++;
            }
        }
        String[] foodOnly = new String[countFood];
        int position = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getType().equals(type)) {
                foodOnly[position] = orders[i].getNameOfItem();
                position++;
            }
        }
        return foodOnly;
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
