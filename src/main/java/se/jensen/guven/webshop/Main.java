package se.jensen.guven.webshop;

import se.jensen.guven.webshop.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();

        Menu menu = new Menu(scanner, productRepository);
        menu.showMenu();

    }
}
