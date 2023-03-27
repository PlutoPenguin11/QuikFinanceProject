package com.example.quikfinance;

public class Transaction {
    //Could store as ID or as string
    private CategoryClass category;
    //store as int in cents
    protected int price;
    private String date;
    private String description;
    private boolean wasPaid;

    public Transaction(CategoryClass category, int amount, String date, boolean wasPaid) {
        this.category = category;
        this.price = amount;
        this.date = date;
        this.wasPaid = wasPaid;
        this.description = "Transaction for " + category.getID();
        category.updatePrice(amount);
    }

    public Transaction(CategoryClass category, int amount, String date, boolean wasPaid, String description) {
        this.category = category;
        this.price = amount;
        this.date = date;
        this.wasPaid = wasPaid;
        this.description = description;
        category.updatePrice(amount);
    }

    public void setCategory(CategoryClass newCategory) {
        category = newCategory;
    }

    //Precondition: String is a valid date
    public void setDate(String newDate) {
        date = newDate;
    }

    public void setStatus(boolean newStatus) {
        wasPaid = newStatus;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setPrice(int amount) {
        category.updatePrice(-price);
        category.updatePrice(price = amount);
    }

    //Converts cents back to $x.xx format and returns
    public String getPrice() {
        String money = "" + (price * 100);
        String dollars = money.substring(0, money.length() - 2);
        String cents = money.substring(money.length() - 2);
        return "$" + dollars + "." + cents;
    }

    public CategoryClass getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public boolean getStatus() {
        return wasPaid;
    }

    public String getDescription() {
        return description;
    }
}