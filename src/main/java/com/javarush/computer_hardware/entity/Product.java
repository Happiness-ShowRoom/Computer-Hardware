package com.javarush.computer_hardware.entity;

import javax.persistence.*;

@Entity
@Table(name = "components", schema = "computer_hardware")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "necessary")
    private boolean necessary;

    @Column(name = "quantity")
    private int quantity;

    public Product() {
    }

    public Product(String name, boolean necessary, int quantity) {
        this.name = name;
        this.necessary = necessary;
        this.quantity = quantity;
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

    public boolean isNecessary() {
        return necessary;
    }

    public void setNecessary(boolean necessary) {
        this.necessary = necessary;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
