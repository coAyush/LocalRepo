package com.mycompany.nexus.Model;

public class Coin {

    private int id;
    private String symbol;
    private String name;
    private double price;
    private String image;
    private double price_change_percentage_24h;

    // getters
    public int getId() { return id; }
    public String getSymbol() { return symbol; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImage() { return image; }
    public double getPrice_change_percentage_24h() {
        return price_change_percentage_24h;
    }

    // setters (REAL setters)
    public void setId(int id) { this.id = id; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setImage(String image) { this.image = image; }
    public void setPrice_change_percentage_24h(double val) {
        this.price_change_percentage_24h = val;
    }
}
