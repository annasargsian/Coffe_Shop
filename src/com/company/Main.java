package com.company;

public class Main {

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        MenuItem pasta = new MenuItem();
        pasta.setNameOfItem("pasta");
        pasta.setType("food");
        pasta.setPrice(20.0);
        MenuItem water = new MenuItem();
        water.setNameOfItem("bonAqua");
        water.setType("drink");
        water.setPrice(1.5);
        MenuItem[] orders = new MenuItem[2];
        orders[0] = water;
        orders[1] = pasta;
        coffeeShop.setMenu(orders);
        for (int i = 0; i < 2; i++) {
            System.out.println(coffeeShop.addOrder(orders[i]));
        }

        coffeeShop.cheapestItem(orders);

        String[] result = coffeeShop.foodOnly(orders);
        String[] listOfOrders = coffeeShop.listOfOrders();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
        String[] drinkOnly = coffeeShop.drinksOnly(orders);
        for (int i = 0; i < drinkOnly.length; i++) {
            System.out.println(drinkOnly[i]);
        }
        if (listOfOrders.length == 0) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < listOfOrders.length; i++) {
                if (listOfOrders[i] == null) {
                    break;
                }
                System.out.println(listOfOrders[i]);
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(coffeeShop.fulFillOrder(orders[i]));
        }
        coffeeShop.dueAmount();

    }
}
