package com.techelevator.Currency;

import com.techelevator.Inventory.Item;

import java.math.BigDecimal;

public class Money {
    private double balance;


//    public void moneyRemaining (int )

   public void moneyRemaining(Item inputItem ){
        new BigDecimal(balance+ "").subtract(inputItem.getPrice()) ;

   }

    public Money() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

 public double moneyIn(int userFunds){
        balance += userFunds;
        return balance;
 }
//money provided incrementation processes


}


