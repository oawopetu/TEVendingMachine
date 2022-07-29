package com.techelevator.Inventory;

public class Munchy extends Item {

    public Munchy(String slotLocation){
        super(slotLocation);

    }
    @Override
    public String getSaying() {
        return "Munchy, Munchy, so Good!";
    }
}
