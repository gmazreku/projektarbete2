package se.jensen.guven.webshop.model;

public class Computer extends Product{
    @Override
    public String category() {
        return "Dator";
    }

    public Computer(int articleNumber, String title, double price, String description){
        super(articleNumber, title, price, description);
    }
}
