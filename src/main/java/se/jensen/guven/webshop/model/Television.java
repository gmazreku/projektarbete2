package se.jensen.guven.webshop.model;

public class Television extends Product {
    @Override
    public String category() {

        return "TV";
    }
    public Television(int articleNumber, String title, double price, String description){
        super(articleNumber, title, price, description);
    }
}
