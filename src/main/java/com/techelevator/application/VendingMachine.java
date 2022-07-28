package com.techelevator.application;

import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();

    public void run() {
        while(true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);
            if(choice.equals("display")) {
                InventoryBuilder inventoryBuilder = new InventoryBuilder();
            }
            else if(choice.equals("purchase")) {
                // make a purchase
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }
}
