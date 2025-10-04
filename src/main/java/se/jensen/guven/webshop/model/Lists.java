package se.jensen.guven.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    private List<Product> products;

    public List<Product> getProducts(){

        return new ArrayList<>(products);
    }

    public Lists(){

        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }
}
