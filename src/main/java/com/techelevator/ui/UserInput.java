package com.techelevator.ui;

import com.techelevator.Inventory.Item;
import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.Currency.Money;
import com.techelevator.Writer.AuditLog;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);
    InventoryBuilder inventoryBuilder = new InventoryBuilder();
    Item item;

    AuditLog audit = new AuditLog();

    public String getHomeScreenOption() {
        try {
            System.out.println("What would you like to do?");
            System.out.println();

            System.out.println("D) Display Items");
            System.out.println("P) Purchase");
            System.out.println("E) Exit");

            System.out.println();
            System.out.print("Please select an option: ");

            String selectedOption = scanner.nextLine();
            String option = selectedOption.trim().toLowerCase();
            System.out.println("option = " + option);
            if (option.equals("d")) {
                return "display";
            } else if (option.equals("p")) {
                return "purchase";
            } else if (option.equals("e")) {
                return "exit";
            } else {
                return "display";
            }
        }catch (NumberFormatException ex){
            System.out.println("Please enter a valid request");
            return "Purchase";
        }
    }
    public String getPurchaseOption() {

        System.out.println();
        System.out.print("Please select an option: ");

        String purchaseOption = scanner.nextLine();
        String purchaseOptionSelected = purchaseOption.trim().toLowerCase();
        System.out.println("option = " + purchaseOptionSelected);
        if (purchaseOptionSelected.equals("m")) {
            return "feed money";
        } else if (purchaseOptionSelected.equals("s")) {
            return "select item";
        } else if (purchaseOptionSelected.equals("f")) {
            return "finish";
        } else {
            return "display";
        }


    }


    public String getFeedMoneyOptions() {

        while (true) {
            System.out.println();
            System.out.print("Select option number to  enter the  money desired.");
            String purchaseOptionSelected = scanner.nextLine();
            String feedMoneySelection = purchaseOptionSelected.trim().toLowerCase();
            System.out.println(" You entered option = " + purchaseOptionSelected);
            UserOutput.displayFeedMoneyOptions();


            if (purchaseOptionSelected.equals("1")) {
                return "1";
            } else if (purchaseOptionSelected.equals("2")) {
                return "5";
            } else if (purchaseOptionSelected.equals("3")) {
                return "10";
            } else if (purchaseOptionSelected.equals("4")) {
                return "20";
            } else if (feedMoneySelection.equals("5")) {
                return "purchase";
            } else {
                UserOutput.invalidRequest();
            }


        }
    }

//passing in map and money object

    public String getItemSelection(Map<String, Item> inventory, Money money) throws FileNotFoundException, NumberFormatException {

        try {
            UserOutput.displayInventoryItems(inventory);
            System.out.println();
            System.out.print("Please enter the slot number of your most desired treat:");
            //TODO if customer enters invalid slot
            BigDecimal startingBalance = money.getBalance();
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMinimumFractionDigits(2);
            String itemSelected = scanner.nextLine();
            String itemChoice = itemSelected.trim().toUpperCase();


            if (inventoryBuilder.getInventory().containsKey(itemChoice)) {

                System.out.println("Please enter the quantity you desire: ");
                String quantityEntered = scanner.nextLine();
                int numberOrdered = Integer.parseInt(quantityEntered);
                boolean noMore = numberOrdered <= inventory.get(itemChoice).getCount();
//            boolean notEnoughMoney =money.getBalance().compareTo( inventory.get(itemChoice).getPrice().multiply(BigDecimal.valueOf(numberOrdered)))>=0);
                if (numberOrdered <= inventory.get(itemChoice).getCount() &&
                        money.getBalance().compareTo(inventory.get(itemChoice).getPrice().multiply(BigDecimal.valueOf(numberOrdered))) >= 0) {

                    inventory.get(itemChoice).buyItem(numberOrdered);
                    System.out.println("You chose " + quantityEntered + " " + inventory.get(itemChoice).getName() + " at " + "$" + inventory.get(itemChoice).getPrice());
                    System.out.println("Your total price is " + (inventory.get(itemChoice).getPrice().multiply(BigDecimal.valueOf(numberOrdered))));
                    money.moneyRemaining2(inventory.get(itemChoice).getPrice().multiply(BigDecimal.valueOf(numberOrdered)));
                    System.out.println(inventory.get(itemChoice).getSaying());
                    audit.auditLog(" " + inventory.get(itemChoice).getName() + " " + inventory.get(itemChoice).getSlotLocation() + " $" + numberFormat.format(startingBalance) + " $" + money.getBalance().toString());
                } else if (!noMore) {
                    UserOutput.outOfStock();
                    return "purchase";
                } else {
                    UserOutput.enterMoreMoney();
                    return "purchase";
                }
            } else {
                UserOutput.invalidRequest();
                getItemSelection(inventory, money);
            }


        }catch (NumberFormatException ex){
            System.out.println("Please enter a valid request");
            return "Purchase";
        }catch(NullPointerException ex){
            System.out.println("Location does not exist");
            return "Purchase";
        } return "display";
    }




}
