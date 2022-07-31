package com.techelevator;


import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.application.VendingMachine;

import java.io.FileNotFoundException;

public class VendingMachineCLI {

	public static void main(String[] args) throws FileNotFoundException {
		InventoryBuilder inventoryBuilder = new InventoryBuilder();
		VendingMachine vendingMachine = new VendingMachine(inventoryBuilder);
		vendingMachine.run();
	}
}
