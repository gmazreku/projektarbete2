package se.jensen.guven.webshop.model;

import se.jensen.guven.webshop.ui.UI;

public class WebshopAdmin {
    private final UI ui;
    private final ProductRepository productRepository;

    public WebshopAdmin(UI ui, ProductRepository productRepository){
        this.ui = ui;
        this.productRepository = productRepository;
    }

    public void run(){
        ui.info("\n## VÄLKOMMEN TILL WEBSHOPEN! ##\n");
        while(true){

            String input = ui.menu();

            switch(input) {
                case "1" -> {
                    userAddProduct(input);
                }
                case "2" -> {
                    userListProduct(input);
                }
                case "3" -> {
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

        ui.info("Vilken typ av produkt vill du lägga till?");
        ui.info("1. Dator");
        ui.info("2. Mobiltelefon");
        ui.info("3. TV");
        ui.info("4. Gå tillbaka. \n");

        input = ui.prompt("");
        switch(input){
            case "1" -> {
                int articleNumber = Integer.parseInt(ui.prompt("Lägg till ett artikelnummer:"));

                String title = ui.prompt("Skriv vad datorn heter:");

                double price = Double.parseDouble(ui.prompt("Vad kostar varan i kronor? Skriv endast siffror:"));

                String description = ui.prompt("Skriv en beskrivning om produkten:");

                Computer computer = new Computer(articleNumber, title, price, description);

                productRepository.addProduct(computer);

                ui.info("Datorn är nu tillagd med artikelnummer " + articleNumber + "\n");
            }
            case "2" -> {
                int articleNumber = Integer.parseInt(ui.prompt("Lägg till ett artikelnummer"));

                String title = ui.prompt("Skriv vad telefonen heter:");

                double price = Double.parseDouble(ui.prompt("Vad kostar varan i kronor? Skriv endast siffror:"));

                String description = ui.prompt("Skriv en beskrivning om produkten:");

                Phone phone = new Phone(articleNumber, title, price, description);

                productRepository.addProduct(phone);

                ui.info("Mobiltelefonen är nu tillagd med artikelnummer " + articleNumber  + ". \n");
            }
            case "3" -> {
                int articleNumber = Integer.parseInt(ui.prompt("Lägg till ett artikelnummer"));

                String title = ui.prompt("Skriv vad TV'n heter:");

                double price = Double.parseDouble(ui.prompt("Vad kostar varan i kronor? Skriv endast siffror:"));

                String description = ui.prompt("Skriv en beskrivning om produkten:");

                Television tv = new Television(articleNumber, title, price, description);

                productRepository.addProduct(tv);

                ui.info("TV'n är nu tillagd med artikelnummer " + articleNumber  + ".\n");
            }
            case "4" -> {
                ui.info("Går tillbaka..");
                break;
            }
            default -> ui.info("Ogiltigt val, skriv siffran igen. \n");
        }
    }
    public void userListProduct(String input){
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
        int articleNumber = Integer.parseInt(ui.prompt("Ange artikelnummer på varan:"));
        boolean found = false;

        for(Product p : productRepository.getProducts()){
            if(p.getArticleNumber() == articleNumber){
                ui.info("# Artikelnr: " + p.getArticleNumber());
                ui.info("# Produkt: " + p.getTitle());
                ui.info("# Pris: " + p.getPrice() + " kr.");
                ui.info("# Beskrivning: " + p.getDescription());
                ui.info("# Kategori: " + p.category() + "\n");
                found = true;
                break;
            }
        } if(!found) {
            ui.info("Ingen produkt hittades med artikelnummer " + articleNumber + ". Försök igen. \n");
        }
    }
}
