package se.jensen.guven.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts(){

        return new ArrayList<>(products);
    }

    public ProductRepository(){

        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }
}
