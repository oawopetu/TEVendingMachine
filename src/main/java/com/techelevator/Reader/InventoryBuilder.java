package com.techelevator.Reader;

import com.techelevator.Inventory.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryBuilder {

    public Map<String, Item> getInventory(){

        Scanner cateringFileInput = new Scanner(System.in);

        System.out.print("What is the source file?: ");
        String sourceFile = cateringFileInput.nextLine();
        File file = new File("catering.csv");
        Map<String, Item> inventory = new HashMap<>();

        try(Scanner fileScanner = new Scanner(file)){
            while(fileScanner.hasNextLine()){
                Item item;
                String currentLine = fileScanner.nextLine();
                String[] splitCurrentLine = currentLine.split(",");
                if(splitCurrentLine[3].equals("Munchy")) {
                    item = new Munchy(splitCurrentLine[0]);
                }else if(splitCurrentLine[3].equals("Drink")){
                    item = new Drink(splitCurrentLine[0]);
                }else if(splitCurrentLine[3].equals("Candy")){
                    item = new Candy(splitCurrentLine[0]);
                }else{item = new Gum(splitCurrentLine[0]);
                }
                item.setType(splitCurrentLine[3]);
                item.setPrice(new BigDecimal(splitCurrentLine[2]));
                item.setName(splitCurrentLine[1]);
                inventory.put(splitCurrentLine[0],item);

            }

        }catch(FileNotFoundException e){
            System.out.println("File not found at " + file.getAbsolutePath());
        }return inventory;

    }
}
