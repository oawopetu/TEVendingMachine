package com.techelevator.Inventory;

public class Munchy extends Item {

    public Munchy(String slotLocation){
        super(slotLocation);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public String getSaying() {
        return "Munchy, Munchy, so Good!";
    }
}
