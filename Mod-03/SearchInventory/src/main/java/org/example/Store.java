package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        try{
            FileReader fr = new FileReader("inventory.csv");
            BufferedReader br = new BufferedReader(fr);

            String dataLine;
            String[] dataFields;
            while(br.readLine() != null){
                dataLine = br.readLine();
                dataFields = dataLine.split("\\|");
                Product newProduct = new Product (Integer.parseInt(dataFields[0]), dataFields[1], Float.parseFloat(dataFields[2]));
                inventory.add(newProduct);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return inventory;
    }
}
