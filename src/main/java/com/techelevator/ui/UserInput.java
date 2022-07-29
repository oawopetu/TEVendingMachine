package com.techelevator.ui;

import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.Currency.Money;

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

        public String getPurchaseOption(){

            System.out.println();
            System.out.print("Please select an option: ");

            String purchaseOption = scanner.nextLine();
            String purchaseOptionSelected = purchaseOption.trim().toLowerCase();
            System.out.println("option = " + purchaseOptionSelected);
            if (purchaseOptionSelected.equals("m")) {
                UserOutput.displayFeedMoneyOptions();
                System.out.println(getFeedMoneyOptions());
            } else if (purchaseOptionSelected.equals("s")) {
                return "select item";
            } else if (purchaseOptionSelected.equals("f")) {
                return "finish";
            } else {
                return "";
            }
            return "";

        }

        public String getFeedMoneyOptions(){

        System.out.println();
        System.out.print("Select option number to  enter the  money desired.");
        String purchaseOptionSelected = scanner.nextLine();
        System.out.println(" You entered option = " + purchaseOptionSelected);
        int moneyProv =0;
        if (purchaseOptionSelected.equals("1")) {
             moneyProv +=1 ;
        } else if (purchaseOptionSelected.equals("2")) {
            moneyProv +=5 ;
        } else if (purchaseOptionSelected.equals("3")) {
            moneyProv +=10 ;
        } else if (purchaseOptionSelected.equals("4")) {
            moneyProv +=20;
        } else {
            return "Please enter a valid request ";
        }

            return "Current Money provided is $" + moneyProv;
        }
    }

