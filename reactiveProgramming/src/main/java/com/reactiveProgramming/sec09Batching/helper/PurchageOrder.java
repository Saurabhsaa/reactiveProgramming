package com.reactiveProgramming.sec09Batching.helper;

import com.reactiveProgramming.utility.Util;

public class PurchageOrder {

    private String item;
    private double price;
    private String category;
    private int quantity;

    public PurchageOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.category = Util.faker().commerce().department();
        this.quantity = Util.faker().random().nextInt(1,10);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "PurchageOrder{" +
                "item='" + item + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }


}
