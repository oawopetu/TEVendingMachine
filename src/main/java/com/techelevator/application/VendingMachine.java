package com.techelevator.application;

import com.techelevator.Inventory.Item;
import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    private Map<String, Item> inventory = new HashMap<>();

    public VendingMachine(InventoryBuilder inventoryBuilder){
        inventory = inventoryBuilder.getInventory();
    }

    public void run() {
        while(true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);
            if(choice.equals("display")) {
                UserOutput.displayInventoryItems(inventory);
            }
            else if(choice.equals("purchase")) {
                UserOutput.displayPurchaseOptions();
                String purchaseChoice = userInput.getPurchaseOption();
                System.out.println(purchaseChoice);


//                UserOutput.displayMessage("Enter the slot location of the treat you wish to purchase: ");


//                String itemKey = UserInput.getItemKeyUserSelected();
//                UserOutput.displayMessage("You selected " + inventory.get(itemKey).getName() + " at a price of: $ " + inventory.get(itemKey).getPrice());
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }
}
