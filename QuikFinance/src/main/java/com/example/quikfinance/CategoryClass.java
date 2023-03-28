package com.example.quikfinance;
//this is the class for creating categories for whatever you are buying !!!????
//
public class CategoryClass {
    private int totalCost;
    private int ID;
    private String itemCategory = null;

    //Derek
    public CategoryClass(int ID, String itemcategory) {
        this.totalCost = 0;
        this.itemCategory = itemcategory;
        this.ID = ID;
    }
    public int getID() {
        return this.ID;
    }

    public int getPrice() {
        return this.totalCost;
    }

    public String getCategory() {
        return this.itemCategory;
    }
    public void printInfo() {
        System.out.println("Item ID:       "+ getID());
        System.out.println("Item category: "+getCategory());
        System.out.println("Total cost:    $"+getPrice());
    }

    protected void updatePrice(int change) {
        totalCost += change;
    }

    public void setPrice(int price) {
        totalCost = price;
    }

    public void setID(int newID) {
        ID = newID;
    }

    public void setItemCategory(String newName) {
        itemCategory = newName;
    }
}
