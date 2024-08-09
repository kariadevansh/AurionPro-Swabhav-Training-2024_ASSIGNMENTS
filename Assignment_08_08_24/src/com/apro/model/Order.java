package com.apro.model;


import java.sql.Date;

public class Order {
    private int id;
    private Date date;
    private int supplierId;

    public Order(int id, Date date, int supplierId) {
        this.id = id;
        this.date = date;
        this.supplierId = supplierId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}

