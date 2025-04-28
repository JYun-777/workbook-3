package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Store {
    // the key is the product id, the value is a product object
    static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();
    public static void main(String[] args) {
        // this method loads product objects into inventory
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("What item # are you interested in? ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Product matchedProduct = inventory.get(id);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
            }else {
                System.out.printf("We carry %s and the price is $%.2f",
                        matchedProduct.getName(), matchedProduct.getPrice());
            }

            System.out.print("Enter Y to search another product, or N to close: ");
            if(!scanner.nextLine().equalsIgnoreCase("Y")){
                break;
            }
        }
    }

    public static void loadInventory(){
        try{
            FileReader fr = new FileReader("inventory.csv");
            BufferedReader br = new BufferedReader(fr);

            String dataLine;
            String[] dataFields;
            while((dataLine = br.readLine()) != null) {
                dataFields = dataLine.split("\\|");
                Product newProduct = new Product (Integer.parseInt(dataFields[0]), dataFields[1], Float.parseFloat(dataFields[2]));
                //put new product in inventory hashmap with product id as a key
                inventory.put(newProduct.getId(), newProduct);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }



}
