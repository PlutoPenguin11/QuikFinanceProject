package com.example.quikfinance;

public class Transaction {
    private String date;
    private String description;
    private Category category;
    private boolean wasPaid;
    protected int amount;

    public Transaction(String date, String description, Category category, boolean wasPaid, int amount) {
        this.date = date;
        this.description = description;
        this.category = category;
        this.wasPaid = wasPaid;
        this.amount = amount;

        category.updatePrice(amount);
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
    public void setCategory(Category newCategory) {
        category = newCategory;
    }
    public Category getCategory() {
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
    public void setAmount(int amount) {
        category.updatePrice(-amount);
        category.updatePrice(this.amount = amount);
    }
    public String getAmount() {
        String money = "" + amount;
        String dollars = money.substring(0, money.length() - 2);
        String cents = money.substring(money.length() - 2);
        return "$" + dollars + "." + cents;
    }
}