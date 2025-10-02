package se.jensen.guven.webshop;

import se.jensen.guven.webshop.model.Lists;
import se.jensen.guven.webshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Lists list = new Lists();

       list.addProduct();

       for(Product p : list.getProducts()){
           System.out.println("Artikelnr: " + p.getArticleNumber());
           System.out.println("Produkt: " + p.getTitle());
           System.out.println("Pris: " + p.getPrice() + " kr.");
           System.out.println("Beskrivning: " + p.getDescription());
           System.out.println("Kategori: " + p.category());
           System.out.println("############################");
       }
    }
}
