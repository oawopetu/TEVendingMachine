package com.techelevator.Inventory;

public class Gum extends Item {

    public Gum(String slotLocation) {
        super(slotLocation);
    }

    @Override
    public String getSaying() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}
