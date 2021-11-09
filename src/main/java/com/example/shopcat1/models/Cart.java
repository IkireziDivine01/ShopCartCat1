package com.example.shopcat1.models;

import javax.persistence.*;


//@Table
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String item;
    private int unitPrice;

    //one customer can buy many items and many customers can buy one item


    public Cart() {
    }

    public Cart(String name, String item, int unitPrice) {
        this.name = name;
        this.item = item;
        this.unitPrice = unitPrice;
    }

    public Cart(Long id, String name, String item, int unitPrice) {
        this.id = id;
        this.name = name;
        this.item = item;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
