package com.techelevator.ui;

import com.techelevator.Inventory.Item;

import java.util.Map;

public class UserOutput {
    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayInventoryItems(Map<String, Item> inventory) {
        for (Map.Entry<String, Item> itemEntry : inventory.entrySet()) {
            System.out.println("[" + itemEntry.getKey() + "] " + itemEntry.getValue().getName() + " : " + itemEntry.getValue().getPrice());
        }
    }
}