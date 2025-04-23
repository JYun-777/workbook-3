package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductReader {

    Scanner read = new Scanner(System.in);

    public static List<Product> readProductFromCSVFile(String fileName) {

        List<Product> productList = new ArrayList<>();
        //
         //Pseudocode: Break down steps to plain English

        //0. Try/catch necessary
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            // Skip the first line (it contains column names like id,name,price,stock)
            reader.readLine();

            String line;
            // Read each remaining line in the file
            while ((line = reader.readLine()) != null) {
                // Split the line into parts, using comma as the separator
                String[] parts = line.split(",");

                // Check if the line has exactly 4 parts (id, name, price, stock)
                if (parts.length == 4) {
                    Product p = getProduct(parts);

                    // Add the product to the list
                    productList.add(p);
                    System.out.println(p.getName() + " has been added to the list");
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong with reading the file.");
        }
        //1. Read the file
        //2. Store data internally into variables
        //3. Create a product object
        //4. Add product to arraylist
        return productList;
    }

    private static Product getProduct(String[] parts) {
        int id = Integer.parseInt(parts[0]);        // Convert the first part to an integer (ID)
        String name = parts[1];                     // Get the name as text
        double price = Double.parseDouble(parts[2]); // Convert price to a decimal number
        int stock = Integer.parseInt(parts[3]);     // Convert stock to an integer

        // Create a new Product object using the parts
        Product p = new Product(id, name, price, stock);
        return p;
    }
}
