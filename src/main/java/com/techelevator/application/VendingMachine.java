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
    Money money = new Money();
    private int moneyProvided;
    public int getMoneyProvided() {
        return moneyProvided;
    }

    private Map<String, Item> inventory = new HashMap<>();

    public VendingMachine(InventoryBuilder inventoryBuilder) {
        inventory = inventoryBuilder.getInventory();
    }


    public void run() {
        userOutput.displayHomeScreen();
        String choice = userInput.getHomeScreenOption();
        System.out.println("Your current balance is $" + moneyProvided);

        while (true) {

            System.out.println(choice);
            if (choice.equals("display")) {
                UserOutput.displayInventoryItems(inventory);

                userOutput.displayHomeScreen();
                choice = userInput.getHomeScreenOption();
            } else if (choice.equals("purchase")) {
                    UserOutput.displayPurchaseOptions();
//                System.out.println("Your current balance is $" + moneyProvided);
                    String purchaseChoice = userInput.getPurchaseOption();
                    if (purchaseChoice.equals("feed money")) {
                        UserOutput.displayFeedMoneyOptions();

                        choice = userInput.getFeedMoneyOptions();
                    } else if(purchaseChoice.equals("select item")){
                        UserOutput.displayInventoryItems(inventory);
                    String userChoice = "A1";
                    inventory.get(userChoice).buyItem(1);

                        System.out.println(inventory.get(userChoice).getCount());

                    }


//                UserOutput.displayMessage("Enter the slot location of the treat you wish to purchase: ");
//                String itemKey = UserInput.getItemKeyUserSelected();
//                UserOutput.displayMessage("You selected " + inventory.get(itemKey).getName() + " at a price of: $ " + inventory.get(itemKey).getPrice());
                }
            else if (choice.equals("exit")) {
                    // good bye
                    break;
                }
            }
        }
    }
