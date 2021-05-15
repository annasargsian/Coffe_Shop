package com.company;

public class CoffeeShop {
    private String nameOfCoffeeShop;
    private MenuItem[] orders = new MenuItem[100];
    private MenuItem[] menu = new MenuItem[100];
    private int currentElementOfOrders = 0;
    private int currentPriceOfOrder = 0;

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
            return "Ok";
        }
    }

    public String[] listOfders(MenuItem[] orders) {
        int lengthOfArray = 0;
        String[] listOfOrders = new String[lengthOfArray];
        if (currentElementOfOrders > 0) {
            for (int i = 0; i < orders.length; i++) {
                listOfOrders[i] = orders[i].getNameOfItem();
                lengthOfArray++;
            }
            return listOfOrders;
        } else {
            return listOfOrders;
        }
    }

    public void dueAmount(int currentPriceOfOrder) {
        System.out.println("The total amount due for the orders" + currentPriceOfOrder);
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
        int lengthOfDrinksOnly = 0;
        String[] drinksOnly = new String[lengthOfDrinksOnly];
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getType().equals("drink")) {
                drinksOnly[i] = orders[i].getNameOfItem();
                lengthOfDrinksOnly++;
            }
        }
        return drinksOnly;
    }

    public String[] foodOnly(MenuItem[] orders) {
        int lengthOfFoodOnly = 0;
        String[] foodOnly = new String[lengthOfFoodOnly];
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getType().equals("food")) {
                foodOnly[i] = orders[i].getNameOfItem();
                lengthOfFoodOnly++;
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
