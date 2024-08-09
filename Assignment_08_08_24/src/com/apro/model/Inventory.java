package com.apro.model;


public class Inventory {
    private int inventoryId;
    private int productId;
    private int quantityOnHand;

    public Inventory(int inventoryId, int productId, int quantityOnHand) {
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.quantityOnHand = quantityOnHand;
    }

    // Getters and Setters
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
}
