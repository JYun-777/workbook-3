package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = ProductReader.readProductFromCSVFile("product.csv");

        for(Product p : products){
            System.out.println(p.getPrice());
        }


    }

}