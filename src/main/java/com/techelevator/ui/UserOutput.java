package com.techelevator.ui;

import com.techelevator.Inventory.Item;

import java.util.Map;

public class UserOutput {
    public static void displayMessage(String message) {
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

    public static void displayPurchaseOptions(){
        System.out.println("M) Feed money");
        System.out.println("S) Select item");
        System.out.println("F) Finish transaction");
        System.out.println("");
        System.out.println("Current Money Provided: $");

    }
    public static void displayFeedMoneyOptions(){
        System.out.println("(1) Enter $1");
        System.out.println("(2) Enter $5");
        System.out.println("(3) Enter $10");
        System.out.println("(4) Enter $20");

    }
}