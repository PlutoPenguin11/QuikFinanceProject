package com.example.quikfinance;
import quikConfig.CategoryClass;
import quikConfig.Transaction;

//main class//
public class WorkingUserFinances {

    public static void main(String[] args) {
        CategoryClass item1 = new CategoryClass(5,"entertainment");
        item1.printInfo();
        System.out.println();
        CategoryClass item2 = new CategoryClass(7,"water bill");
        item2.printInfo();
        System.out.println();
        CategoryClass item3 = new CategoryClass(3,"Car insurance");
        item3.printInfo();

        Transaction netflix = new Transaction(item1, 50000000, "5/21/92", true);
    }

}