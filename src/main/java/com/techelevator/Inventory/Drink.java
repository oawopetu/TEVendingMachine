package com.techelevator.Inventory;

public class Drink extends Item {

    public Drink(String slotLocation) {
        super(slotLocation);
    }

    @Override
    public String getSaying() {
        return "Drinky, Drinky, Slurp Slurp";
    }
}