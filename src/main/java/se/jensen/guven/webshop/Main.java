package se.jensen.guven.webshop;

import se.jensen.guven.webshop.model.*;
import se.jensen.guven.webshop.ui.ConsoleUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();

        ConsoleUI ui = new ConsoleUI(scanner);
        WebshopAdmin webAdmin = new WebshopAdmin(ui, productRepository);

        webAdmin.run();

    }
}
