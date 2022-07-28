package com.techelevator.Inventory;

import java.math.BigDecimal;

public abstract class Item {

    private BigDecimal price;
    private String name;
    private String slotLocation;
    private String type;


    //constructor
    public Item(String slotLocation) {
        this.slotLocation = slotLocation;
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



}


