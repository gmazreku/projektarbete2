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

    public void addProduct(){
        products.add(new Phone(203, "iPhone 17 Air", 14999.0, "5.2 tum, "
        + "24 mp kamera, Molnvit, Tillverkad 2025."));
        products.add(new Phone(204, "iPhone 17 Pro", 17999.0, "5.2 tum, "
                + "28 mp kamera, Midnattslila, Tillverkad 2025."));
        products.add(new Phone(205, "iPhone 17 Pro Max", 19999.0, "6 tum, "
                + "32 mp kamera, Galaxy, Tillverkad 2025."));

        products.add(new Computer(301, "MacBook Air 13.3 tum", 15999.0, "13.3 tum, "
                + "12 mp kamera, Midnattsblå, Tillverkad 2024."));
        products.add(new Computer(301, "MacBook Pro 15 tum", 19999.0, "15 tum, "
                + "14 mp kamera, Silver, Tillverkad 2025."));
    }
}
