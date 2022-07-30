package com.techelevator.ui;

import com.techelevator.Inventory.Item;
import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.Currency.Money;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);





    public String getHomeScreenOption() {
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
            return "";
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
            return "";
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
            } else  if (purchaseOptionSelected.equals("2")) {
                return "5";
            } else if (purchaseOptionSelected.equals("3")) {
                return "10";
            } else if (purchaseOptionSelected.equals("4")) {
                return "20";
            } else if (feedMoneySelection.equals("5")) {
                return "purchase";
            } else{
                System.out.println("<------------------------>");
                System.out.println("PLEASE ENTER VALID REQUEST ");
                System.out.println("<------------------------>");
            }



        }
    }

    public String getItemSelection(Map<String,Item> inventory){
//this whole method is functional now. I'm not
        UserOutput.displayInventoryItems(inventory);
        System.out.println();
        System.out.print("Please enter the slot number of your most desired treat:");
        String itemSelected = scanner.nextLine();
        String itemChoice = itemSelected.trim().toUpperCase();
        System.out.println("Please enter the quantity you desire: ");
        String quantityEntered = scanner.nextLine();
        int numberOrdered = Integer.parseInt(quantityEntered);
        inventory.get(itemChoice).buyItem(numberOrdered);
        System.out.println(" You chose " + quantityEntered + " " +  inventory.get(itemChoice).getName() + " at " + "$" + inventory.get(itemChoice).getPrice());
        System.out.println("your total price is " + (inventory.get(itemChoice).getPrice().multiply(BigDecimal.valueOf(numberOrdered))));
        //the next line isn't subtracting for some reason. I think it's because money provided is resetting.
      //  BigDecimal.valueOf(moneyProvided).subtract(inventory.get(itemChoice).getPrice());



        return "";
    }



}
