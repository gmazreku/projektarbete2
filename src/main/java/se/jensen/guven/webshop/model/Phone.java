package se.jensen.guven.webshop.model;

public class Phone extends Product{
    @Override
    public String category() {

        return "Telefon";
    }
    public Phone(int articleNumber, String title, double price, String description){
        super(articleNumber, title, price, description);
    }
}
