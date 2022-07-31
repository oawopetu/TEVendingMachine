package com.techelevator.application;

import com.techelevator.Currency.Money;
import com.techelevator.Inventory.Item;
import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.Writer.AuditLog;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();

    AuditLog audit = new AuditLog();

    Money money = new Money();

    public BigDecimal getMoneyProvided() {
        return money.getBalance();
    }



    private Map<String, Item> inventory = new HashMap<>();

    public VendingMachine(InventoryBuilder inventoryBuilder) {
        inventory = inventoryBuilder.getInventory();
    }

    InventoryBuilder inventoryBuilder = new InventoryBuilder();


    public void run() throws FileNotFoundException {
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

    private String purchaseMenu(String choice) throws FileNotFoundException {
        UserOutput.displayPurchaseOptions();
        UserOutput.currentBalance(money.getBalance());
        String purchaseChoice = userInput.getPurchaseOption();
        BigDecimal startingBalance = money.getBalance();
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumFractionDigits(2);
        String one = "1.00";
        String five = "5.00";
        String ten = "10.00";
        String twenty = "20.00";


        if (purchaseChoice.equals("feed money")) {
            UserOutput.displayFeedMoneyOptions();
             choice = userInput.getFeedMoneyOptions();
            if (choice.equals("1")) {
                money.moneyIn(1);
                audit.auditLog(" MONEY FED " + " $" + one + " $" + numberFormat.format(money.getBalance()));
                choice = "purchase";
            } else if (choice.equals("5")) {
                money.moneyIn(5);
                audit.auditLog(" MONEY FED " + " $" + five + " $" + numberFormat.format(money.getBalance()));
                choice = "purchase";
            } else if (choice.equals("10")) {
                money.moneyIn(10);
                audit.auditLog( " MONEY FED " + " $" + ten + " $" + numberFormat.format(money.getBalance()));
                choice = "purchase";
            } else if (choice.equals("20")) {
                money.moneyIn(20);
                audit.auditLog(" MONEY FED " + " $" + twenty + " $" + numberFormat.format(money.getBalance()));
                choice = "purchase";
            } else if (choice.equals("purchase")){
                choice = "purchase";
            }


        } else if (purchaseChoice.equals("select item")) {
            userInput.getItemSelection(inventory,money);
            UserOutput.currentBalance(money.getBalance());

            //this should probably be in money
//                    BigDecimal.valueOf(money.getMoneyProvided()).subtract(inventory.get(userInput.getItemSelection(inventory.(itemChoice))).getPrice());
        }
        else if (purchaseChoice.equals("finish")){
            audit.auditLog(" CHANGE GIVEN" + " $" + money.getBalance() + " $0.00");
            money.customerChange();
            UserOutput.currentBalance(money.getBalance());
            UserOutput.displayHomeScreen();
            choice = userInput.getHomeScreenOption();


        }
        else{
           UserOutput.invalidRequest();
        }

//                UserOutput.displayMessage("Enter the slot location of the treat you wish to purchase: ");
//                String itemKey = UserInput.getItemKeyUserSelected();
//                UserOutput.displayMessage("You selected " + inventory.get(itemKey).getName() + " at a price of: $ " + inventory.get(itemKey).getPrice());
        return choice;
    }
}
