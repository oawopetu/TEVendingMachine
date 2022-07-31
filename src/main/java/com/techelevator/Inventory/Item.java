package com.techelevator.Inventory;

import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;

public abstract class Item {

    private BigDecimal price;
    private String name;
    private String slotLocation;
    private String type;
    private String saying;



    //constructor
    public Item(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public  int getCount() {
        return count;
    }

    private int count = 6;

    public void buyItem(int amountToBuy){
        if(amountToBuy>count){

            System.out.println("Please select a smaller amount.");//what will we tell customer if they ask for too much
        }else{
            count= count - amountToBuy;
        }
    }




    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaying() {
        return saying;
    }


}


