package se.jensen.guven.webshop.ui;

import java.util.Scanner;

public class ConsoleUI implements UI{
    private Scanner scanner;

    public ConsoleUI(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public String menu() {
        System.out.println("Välj följande siffra för att gå vidare");
        System.out.println("1. Lägg till produkt");
        System.out.println("2. Lista alla upplagda produkter");
        System.out.println("3. Visa info om produkt");
        System.out.println("4. Avsluta");

        return scanner.nextLine();
    }
}
