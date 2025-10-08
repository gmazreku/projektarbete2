package se.jensen.guven.webshop.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts(){
        return new ArrayList<>(products);
    }

    public ProductRepository(){
        // Skapar en tom lista med ArrayList
        this.products = new ArrayList<>();

        // Skapar en path till filen där produkterna ska sparas
        Path file = Path.of("products.txt");
        // Kollar om den redan finns, finns den så laddar vi den med loadFromFile metoden
        if(Files.exists(file)){
            loadFromFile("products.txt");
        }
    }

    public void addProduct(Product product){
        // Lägger till produkter i listan och sen sparar dem i "product.txt" filen.
        products.add(product);
        saveToFile("products.txt");
    }

    public void saveToFile(String filename){
        String content = "";
        // Loopar genom alla produkter och bygger en rad för varje produkt med | som separator.
        for(Product p : products){
            content = content
                    + p.getClass().getSimpleName() + "|" // Vi använder getSimpleName så att den endast skriver ut kategorin i txt filen.
                    + p.getArticleNumber() + "|"
                    + p.getTitle() + "|"
                    + p.getPrice() + "|"
                    + p.getDescription()
                    + "\n";
        }
        // Skriver hela innehållet till filen, skriver felmeddelande om det blir något sådant.
        Path file = Path.of(filename);
        try {
            Files.writeString(file, content);
        } catch (IOException e){
            System.err.println("Fel vid skrivning: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename){

        Path file = Path.of(filename);
        try {
            // Läser alla rader från filen till en lista, loopar genom alla produkter och delar upp dem med en | separator.
            List<String> lines = Files.readAllLines(file);
            for(String line : lines){
                String[] parts = line.split("\\|"); // "\\" används eftersom specialtecken i regex (frågat AI efter jag fick massa problem)
                int articleNumber = Integer.parseInt(parts[1]);
                String title = parts[2];
                double price = Double.parseDouble(parts[3]);
                String description = parts[4];

                // Skapar rätt produkt baserat på kategori
                switch(parts[0]){
                    case "Computer" -> {
                        Computer computer = new Computer(articleNumber, title, price, description);
                        products.add(computer);
                    }
                    case "Phone" -> {
                        Phone phone = new Phone(articleNumber, title, price, description);
                        products.add(phone);
                    }
                    case "Television" -> {
                        Television tv = new Television(articleNumber, title, price, description);
                        products.add(tv);
                    }
                }
            }
        } catch (IOException e){
            System.err.println("Fel vid läsning: " + e.getMessage());
        }
    }
}
