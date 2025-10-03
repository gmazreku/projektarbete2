package se.jensen.guven.webshop.model;

public abstract class Product {
    private int articleNumber;
    private String title;
    private double price;
    private String description;

    public Product(int articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }


    public int getArticleNumber() {

        return articleNumber;
    }

    public String getTitle() {

        return title;
    }

    public double getPrice() {

        return price;
    }


    public String getDescription() {

        return description;
    }

    public abstract String category();
}
