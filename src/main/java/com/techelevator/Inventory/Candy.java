package com.techelevator.Inventory;

public class Candy extends Item {
    public Candy(String slotLocation) {
        super(slotLocation);
    }
    @Override
    public String getSaying() {
        return "Sugar, Sugar, so Sweet!";
    }
}