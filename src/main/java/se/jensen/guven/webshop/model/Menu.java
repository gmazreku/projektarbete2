package se.jensen.guven.webshop.model;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ProductRepository productRepository;

    public Menu(Scanner scanner, ProductRepository productRepository){
        this.scanner = scanner;
        this.productRepository = productRepository;
    }

    public  void showMenu(){
        System.out.println("## VÄLKOMMEN TILL WEBSHOPEN! ##");
        while(true){
            System.out.println("Välj följande siffra för att gå vidare");
            System.out.println("1. Lägg till produkt");
            System.out.println("2. Lista alla upplagda produkter");
            System.out.println("3. Visa info om produkt");
            System.out.println("4. Avsluta");
            System.out.println();

            String input = scanner.nextLine().trim();


            switch(input) {
                case "1" -> {
                    // Lägg till produkt loop
                    System.out.println("Vilken typ av produkt vill du lägga till?");
                    System.out.println("1. Dator");
                    System.out.println("2. Mobiltelefon");
                    System.out.println("3. TV");
                    System.out.println("4. Gå tillbaka. \n");

                    input = scanner.nextLine().trim();
                    switch(input){
                        case "1" -> {
                            System.out.println("Lägg till ett artikelnummer:");
                            int articleNumber = Integer.parseInt(scanner.nextLine().trim());

                            System.out.println("Skriv vad datorn heter:");
                            String title = scanner.nextLine().trim();

                            System.out.println("Vad kostar varan i kronor? Skriv endast siffror:");
                            double price = Double.parseDouble(scanner.nextLine().trim());

                            System.out.println("Skriv en beskrivning om produkten:");
                            String description = scanner.nextLine().trim();

                            Computer computer = new Computer(articleNumber, title, price, description);

                            productRepository.addProduct(computer);

                            System.out.println("Datorn är nu tillagd med artikelnummer " + articleNumber + "\n");
                        }
                        case "2" -> {
                            System.out.println("Lägg till ett artikelnummer");
                            int articleNumber = Integer.parseInt(scanner.nextLine().trim());

                            System.out.println("Skriv vad telefonen heter:");
                            String title = scanner.nextLine().trim();

                            System.out.println("Vad kostar varan i kronor? Skriv endast siffror:");
                            double price = Double.parseDouble(scanner.nextLine().trim());

                            System.out.println("Skriv en beskrivning om produkten:");
                            String description = scanner.nextLine().trim();

                            Phone phone = new Phone(articleNumber, title, price, description);

                            productRepository.addProduct(phone);

                            System.out.println("Mobiltelefonen är nu tillagd med artikelnummer " + articleNumber  + ". \n");
                        }
                        case "3" -> {
                            System.out.println("Lägg till ett artikelnummer");
                            int articleNumber = Integer.parseInt(scanner.nextLine().trim());

                            System.out.println("Skriv vad TV'n heter:");
                            String title = scanner.nextLine().trim();

                            System.out.println("Vad kostar varan i kronor? Skriv endast siffror:");
                            double price = Double.parseDouble(scanner.nextLine().trim());

                            System.out.println("Skriv en beskrivning om produkten:");
                            String description = scanner.nextLine().trim();

                            Television tv = new Television(articleNumber, title, price, description);

                            productRepository.addProduct(tv);

                            System.out.println("TV'n är nu tillagd med artikelnummer " + articleNumber  + ".\n");
                        }
                        case "4" -> {
                            System.out.println("Går tillbaka..");
                            break;
                        }
                        default -> System.out.println("Ogiltigt val, skriv siffran igen. \n");
                    }
                }
                case "2" -> {
                    for(Product p : productRepository.getProducts()){
                        System.out.println("# Artikelnr: " + p.getArticleNumber());
                        System.out.println("# Produkt: " + p.getTitle());
                        System.out.println("# Pris: " + p.getPrice() + " kr.");
                        System.out.println("# Beskrivning: " + p.getDescription());
                        System.out.println("# Kategori: " + p.category());
                        System.out.println("############################ \n");
                    }
                }
                case "3" -> {
                    System.out.println("Ange artikelnummer på varan:");
                    int articleNumber = Integer.parseInt(scanner.nextLine().trim());
                    boolean found = false;

                    for(Product p : productRepository.getProducts()){
                        if(p.getArticleNumber() == articleNumber){
                            System.out.println("# Artikelnr: " + p.getArticleNumber());
                            System.out.println("# Produkt: " + p.getTitle());
                            System.out.println("# Pris: " + p.getPrice() + " kr.");
                            System.out.println("# Beskrivning: " + p.getDescription());
                            System.out.println("# Kategori: " + p.category() + "\n");
                            found = true;
                            break;
                        }
                    } if(!found) {
                        System.out.println("Ingen produkt hittades med artikelnummer " + articleNumber + ". Försök igen. \n");
                    }
                }
                case "4" -> {
                    System.out.println("Avslutar.. Välkommen åter.");
                    return;
                }
                default -> System.out.println("Ogiltigt val, försök igen. \n");
            }

        }
    }
}
