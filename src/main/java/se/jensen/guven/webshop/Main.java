package se.jensen.guven.webshop;

import se.jensen.guven.webshop.model.Lists;
import se.jensen.guven.webshop.model.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lists lists = new Lists();

        showMenu(scanner, lists);

    }

    public static void showMenu(Scanner scanner, Lists lists){
        System.out.println("## VÄLKOMMEN TILL WEBSHOPEN! ##");
        while(true){
            System.out.println("Välj följande siffra för att gå vidare");
            System.out.println("1. Lägg till produkt");
            System.out.println("2. Lista alla upplagda produkter");
            System.out.println("3. Visa info om produkt");
            System.out.println("4. Avsluta");

            String input = scanner.nextLine().trim();


            switch(input) {
                case "1" -> {
                    // Lägg till produkt loop
                    System.out.println("Vilken typ av produkt vill du lägga till?");
                    System.out.println("1. Dator");
                    System.out.println("2. Mobiltelefon");
                    System.out.println("3. TV");
                    System.out.println("4. Gå tillbaka.");

                    input = scanner.nextLine().trim();
                    switch(input){
                        case "1" -> {
                            System.out.println("1");
                        }
                        case "2" -> {
                            System.out.println("2");
                        }
                        case "3" -> {
                            System.out.println("3");
                        }
                        case "4" -> {
                            System.out.println("Går tillbaka..");
                            return;
                        }
                        default -> System.out.println("Ogiltigt val, skriv siffran igen.");
                    }
                }
                case "2" -> {
                    for(Product p : lists.getProducts()){
                        System.out.println("Artikelnr: " + p.getArticleNumber());
                        System.out.println("Produkt: " + p.getTitle());
                        System.out.println("Pris: " + p.getPrice() + " kr.");
                        System.out.println("Beskrivning: " + p.getDescription());
                        System.out.println("Kategori: " + p.category());
                        System.out.println("############################");
                    }
                }
                case "3" -> {
                    // Visa info om produkt
                }
                case "4" -> {
                    System.out.println("Avslutar.. Välkommen åter.");
                    return;
                }
                default -> System.out.println("Ogiltigt val, försök igen.");
            }

        }
    }
}
