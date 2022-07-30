package com.techelevator.application;

import com.techelevator.Currency.Money;
import com.techelevator.Inventory.Item;
import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();

    //    private int moneyProvided;
    Money money = new Money(getMoneyProvided());

    public int getMoneyProvided() {
        return money.getMoneyProvided();
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
                UserOutput.displayPurchaseOptions();
                UserOutput.currentBalance(money.getMoneyProvided());
                String purchaseChoice = userInput.getPurchaseOption();

                if (purchaseChoice.equals("feed money")) {
                    UserOutput.displayFeedMoneyOptions();
                    userInput.getFeedMoneyOptions();
                    if (userInput.getFeedMoneyOptions() == "1") {
                        money.moneyIn(1);
                    } else if (userInput.getFeedMoneyOptions() == "5") {
                        money.moneyIn(5);
                    } else if (userInput.getFeedMoneyOptions() == "10") {
                        money.moneyIn(10);
                    } else if (userInput.getFeedMoneyOptions() == "20") {
                        money.moneyIn(20);

                    } else if (purchaseChoice.equals("select item")) {
                        userInput.getItemSelection(inventory);
                        UserOutput.currentBalance(money.getMoneyProvided());


                    }

//                UserOutput.displayMessage("Enter the slot location of the treat you wish to purchase: ");
//                String itemKey = UserInput.getItemKeyUserSelected();
//                UserOutput.displayMessage("You selected " + inventory.get(itemKey).getName() + " at a price of: $ " + inventory.get(itemKey).getPrice());
                } else if (choice.equals("exit")) {
                    // good bye
                    break;
                }
            }
        }
    }
}