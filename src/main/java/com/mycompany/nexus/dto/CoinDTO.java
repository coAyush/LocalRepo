package com.mycompany.nexus.dto;

public class CoinDTO {

    private String symbol;
    private String name;
    private double current_price;
    private String image;
    private double price_change_percentage_24h;

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getCurrent_price() { return current_price; }
    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public double getPrice_change_percentage_24h() {
        return price_change_percentage_24h;
    }
    public void setPrice_change_percentage_24h(double v) {
        this.price_change_percentage_24h = v;
    }
}
