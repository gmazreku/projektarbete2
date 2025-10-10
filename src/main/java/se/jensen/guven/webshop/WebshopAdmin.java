package se.jensen.guven.webshop;

import se.jensen.guven.webshop.model.Computer;
import se.jensen.guven.webshop.model.Phone;
import se.jensen.guven.webshop.model.Product;
import se.jensen.guven.webshop.model.Television;
import se.jensen.guven.webshop.repository.ProductRepository;
import se.jensen.guven.webshop.ui.UI;

public class WebshopAdmin {
    // UI för att hantera användarkommunikation, ProductRepository för produkterna.
    // Final säkerställer att vi inte byter ut objekten efter konstruktorn.
    private final UI ui;
    private final ProductRepository productRepository;

    // Konstruktor som skapar WebshopAdmin (för Main klassen)
    public WebshopAdmin(UI ui, ProductRepository productRepository){
        this.ui = ui;
        this.productRepository = productRepository;
    }
    // Run används för att köra huvudmenyn och hantera all input från användaren.
    public void run(){

        // While loop för att menyn inte ska ta slut tills användaren ber om det.
        // Byter ut System.out.println mot info() från UI interfacet.
        ui.info("\n## VÄLKOMMEN TILL WEBSHOPEN! ##\n");
        while(true){

            // Byter även ut menyn till menu() från UI interfacet.
            String input = ui.menu();


            // Här frågas vad användaren vill göra
            switch(input) {
                case "1" -> {
                    // Lägga till produkt
                    userAddProduct(input);
                }
                case "2" -> {
                    // Lista alla produkter
                    userListProduct();
                }
                case "3" -> {
                    // Visa information om tillagd produkt
                    showProductInfo(input);
                }
                case "4" -> {
                    ui.info("Avslutar.. Välkommen åter.");
                    return;
                }
                default -> ui.info("Ogiltigt val, försök igen. \n");
            }

        }
    }

    public void userAddProduct (String input){
        // Här anropas userAddProduct från första switchen
        ui.info("Vilken typ av produkt vill du lägga till?");
        ui.info("1. Dator");
        ui.info("2. Mobiltelefon");
        ui.info("3. TV");
        ui.info("4. Gå tillbaka.");

        // Här byter vi ut scanner.nextLine() mot prompt från UI interfacet.
        input = ui.prompt("");
        switch(input){
            case "1" -> {
                // Här läggs varan till för dator
                int articleNumber = Integer.parseInt(ui.prompt("Lägg till ett artikelnummer:"));

                String title = ui.prompt("Skriv vad datorn heter:");

                double price = Double.parseDouble(ui.prompt("Vad kostar varan i kronor? Skriv endast siffror:"));

                String description = ui.prompt("Skriv en beskrivning om produkten:");

                Computer computer = new Computer(articleNumber, title, price, description);

                productRepository.addProduct(computer);

                ui.info("Datorn är nu tillagd med artikelnummer " + articleNumber + "\n");
            }
            case "2" -> {
                // Här läggs varan till för mobiltelefon
                int articleNumber = Integer.parseInt(ui.prompt("Lägg till ett artikelnummer"));

                String title = ui.prompt("Skriv vad telefonen heter:");

                double price = Double.parseDouble(ui.prompt("Vad kostar varan i kronor? Skriv endast siffror:"));

                String description = ui.prompt("Skriv en beskrivning om produkten:");

                Phone phone = new Phone(articleNumber, title, price, description);

                productRepository.addProduct(phone);

                ui.info("Mobiltelefonen är nu tillagd med artikelnummer " + articleNumber  + ". \n");
            }
            case "3" -> {
                // Här läggs varan till för tv
                int articleNumber = Integer.parseInt(ui.prompt("Lägg till ett artikelnummer"));

                String title = ui.prompt("Skriv vad TV'n heter:");

                double price = Double.parseDouble(ui.prompt("Vad kostar varan i kronor? Skriv endast siffror:"));

                String description = ui.prompt("Skriv en beskrivning om produkten:");

                Television tv = new Television(articleNumber, title, price, description);

                productRepository.addProduct(tv);

                ui.info("TV'n är nu tillagd med artikelnummer " + articleNumber  + ".\n");
            }
            case "4" -> {
                // Om man vill gå tillbaka till menyn.
                ui.info("Går tillbaka..");
                break;
            }
            default -> ui.info("Ogiltigt val, skriv siffran igen. \n");
        }
    }
    public void userListProduct(){
        // Här listar vi produkterna som användaren har lagt till med en for loop
        for(Product p : productRepository.getProducts()){
            ui.info("# Artikelnr: " + p.getArticleNumber());
            ui.info("# Produkt: " + p.getTitle());
            ui.info("# Pris: " + p.getPrice() + " kr.");
            ui.info("# Beskrivning: " + p.getDescription());
            ui.info("# Kategori: " + p.category());
            ui.info("############################ \n");
        }
    }

    public void showProductInfo(String input){
        // Här visar vi information om produkten med en for loop, först läser vi in vilket artikelnummer användaren vill söka.
        int articleNumber = Integer.parseInt(ui.prompt("Ange artikelnummer på varan:"));
        boolean found = false; // sätter standard värdet till false tills vi hittat varan för att sätta den till true.

        for(Product p : productRepository.getProducts()){
            if(p.getArticleNumber() == articleNumber){
                ui.info("# Artikelnr: " + p.getArticleNumber());
                ui.info("# Produkt: " + p.getTitle());
                ui.info("# Pris: " + p.getPrice() + " kr.");
                ui.info("# Beskrivning: " + p.getDescription());
                ui.info("# Kategori: " + p.category() + "\n");
                found = true; // Finns varan så sätter vi den till true
                break;
            }
        } if(!found) {
            // Finns inte varan tillagd, så hänvisar vi med en "not found" if-sats att den inte finns.
            ui.info("Ingen produkt hittades med artikelnummer " + articleNumber + ". Försök igen. \n");

        }
    }
}
