package com.example.quikfinance;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String date;
    private String description;
    private String category;
    private boolean wasPaid;
    protected double amount;

    public Transaction() {
        this.date = "";
        this.description = "";
        this.category = "";
        this.wasPaid = true;
        this.amount = 0;

        // category.updatePrice((int) amount);
    }
    public Transaction(String date, String description, String category, boolean wasPaid, int amount) {
        this.date = date;
        this.description = description;
        this.category = category;
        this.wasPaid = wasPaid;
        this.amount = amount;

        // category.updatePrice(amount);
    }

    // Methods to set and get the date of the transaction.
    public void setDate(String newDate) {
        date = newDate;
    }
    public String getDate() {
        return date;
    }

    // Methods to set and get the description of the transaction.
    public void setDescription(String newDescription) {
        description = newDescription;
    }
    public String getDescription() {
        return description;
    }

    // Methods to set and get the category of the transaction.
    public void setCategory(String newCategory) {
        // category = newCategory;
    }
    public String getCategory() {
        return category;
    }

    // Methods to set and get the boolean that tells us whether the amount was paid or received.
    public void setStatus(boolean newStatus) {
        wasPaid = newStatus;
    }
    public boolean getStatus() {
        return wasPaid;
    }

    // Methods to set and get the amount.
    public void setAmount(double amount) {
        this.amount = amount;
        // category.updatePrice(-amount);
        // category.updatePrice(this.amount = amount);
    }
    public double getAmount() {
        return amount;
    }
}