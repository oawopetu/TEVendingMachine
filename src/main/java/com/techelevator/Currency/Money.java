package com.techelevator.Currency;

import com.techelevator.Inventory.Item;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance;


//    public void moneyRemaining (int )


//   public void moneyRemaining(Item inputItem ){
//        new BigDecimal(balance+ "").subtract(inputItem.getPrice()) ;

    //   }
    public void moneyRemaining2(BigDecimal itemPrice) {
        this.balance = (this.balance).subtract(itemPrice);
    }

    public Money() {
        this.balance = new BigDecimal(0);
    }

    public BigDecimal getBalance() {
        return balance;
    }


    public BigDecimal moneyIn(double userFunds) {
        this.balance = this.balance.add(new BigDecimal(userFunds));
        return balance;

    }

    public BigDecimal customerChange() {

        int onesCounter = 0;
        int quartersCounter = 0;
        int dimesCounter = 0;
        int nickelsCounter = 0;


        BigDecimal ones = new BigDecimal("1.00");
        BigDecimal quarters = new BigDecimal("0.25");
        BigDecimal dimes = new BigDecimal("0.10");
        BigDecimal nickles = new BigDecimal("0.05");


        while (balance.compareTo(BigDecimal.ZERO) > 0) {
            if (balance.compareTo(ones) >= 1) {
                balance = balance.subtract(ones);
                onesCounter++;
            } else if (balance.compareTo(quarters) >= 0.25) {
                balance = balance.subtract(quarters);
                quartersCounter++;
            } else if (balance.compareTo(dimes) >= 0.10) {
                balance = balance.subtract(dimes);
                dimesCounter++;
            } else if (balance.equals(nickles)) {
                balance = balance.subtract(nickles);
                nickelsCounter++;
            } else {
                balance.equals(0.00);
            }



        }
        System.out.println("Your change is: " + onesCounter + " dollars, " + quartersCounter + " quarters, " + dimesCounter + " dimes, and " + nickelsCounter + " nickles.");
//money provided incrementation processes

        return balance;
    }
}


