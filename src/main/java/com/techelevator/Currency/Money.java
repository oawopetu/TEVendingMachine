package com.techelevator.Currency;

import com.techelevator.Inventory.Item;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance;


//    public void moneyRemaining (int )



//   public void moneyRemaining(Item inputItem ){
//        new BigDecimal(balance+ "").subtract(inputItem.getPrice()) ;

//   }
   public void moneyRemaining2( BigDecimal itemPrice){
      this.balance =(this.balance).subtract(itemPrice) ;
   }

    public Money() {
        this.balance = new BigDecimal(0);
    }

    public BigDecimal getBalance() {
        return balance;
    }



 public BigDecimal moneyIn(double userFunds){
        this.balance =this.balance.add(new BigDecimal(userFunds)) ;
        return balance;

 }
 public void customerChange(){

 }

//money provided incrementation processes


}


