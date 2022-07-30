package com.techelevator.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Money {
    private int moneyProvided;

    public Money(int moneyProvided) {
        this.moneyProvided = moneyProvided;
    }

    public int getMoneyProvided() {
        return moneyProvided;
    }

    public void setMoneyProvided(int moneyProvided) {
        this.moneyProvided = moneyProvided;
    }

 public int moneyIn(int userFunds){
        moneyProvided += userFunds;
        return moneyProvided;
 }
//money provided incrementation processes


}


