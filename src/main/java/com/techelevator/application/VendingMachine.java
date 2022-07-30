package com.techelevator.application;

import com.techelevator.Currency.Money;
import com.techelevator.Inventory.Item;
import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();


    Money money = new Money();

    public double getMoneyProvided() {
        return money.getBalance();
    }


    private Map<String, Item> inventory = new HashMap<>();

    public VendingMachine(InventoryBuilder inventoryBuilder) {
        inventory = inventoryBuilder.getInventory();
    }


    public void run() {
        UserOutput.displayHomeScreen();
        String choice = userInput.getHomeScreenOption();

        while (true) {

            System.out.println(choice);
            if (choice.equals("display")) {
                UserOutput.displayInventoryItems(inventory);
                UserOutput.displayHomeScreen();
                choice = userInput.getHomeScreenOption();

            } else if (choice.equals("purchase")) {
                choice = purchaseMenu(choice);
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    private String purchaseMenu(String choice) {
        UserOutput.displayPurchaseOptions();
        UserOutput.currentBalance(money.getBalance());
        String purchaseChoice = userInput.getPurchaseOption();

        if (purchaseChoice.equals("feed money")) {
            UserOutput.displayFeedMoneyOptions();
             choice = userInput.getFeedMoneyOptions();
            if (choice.equals("1")) {
                money.moneyIn(1);
                choice = "purchase";
            } else if (choice.equals("5")) {
                money.moneyIn(5);
                choice = "purchase";
            } else if (choice.equals("10")) {
                money.moneyIn(10);
                choice = "purchase";
            } else if (choice.equals("20")) {
                money.moneyIn(20);
                choice = "purchase";
            } else if (choice.equals("purchase")){
                choice = "purchase";
            }
        } else if (purchaseChoice.equals("select item")) {
            userInput.getItemSelection(inventory);
            UserOutput.currentBalance(money.getBalance());
            //this should probably be in money
//                    BigDecimal.valueOf(money.getMoneyProvided()).subtract(inventory.get(userInput.getItemSelection(inventory.(itemChoice))).getPrice());


        }

//                UserOutput.displayMessage("Enter the slot location of the treat you wish to purchase: ");
//                String itemKey = UserInput.getItemKeyUserSelected();
//                UserOutput.displayMessage("You selected " + inventory.get(itemKey).getName() + " at a price of: $ " + inventory.get(itemKey).getPrice());
        return choice;
    }
}
