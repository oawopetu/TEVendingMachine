package com.techelevator;


import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.application.VendingMachine;

public class VendingMachineCLI {

	public static void main(String[] args) {
		InventoryBuilder inventoryBuilder = new InventoryBuilder();
		VendingMachine vendingMachine = new VendingMachine(inventoryBuilder);
		vendingMachine.run();
	}
}
