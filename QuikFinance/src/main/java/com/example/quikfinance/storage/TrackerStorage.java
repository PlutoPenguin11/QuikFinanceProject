package com.example.quikfinance.storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TrackerStorage {
    private final static String TRACKER_PATH = "QuikFinance/src/main/resources/com/example/quikfinance/tracker.ser";
    private static TrackerStorage uniqueInstance;
    ArrayList<String> expenses;

    private TrackerStorage() {
        expenses = new ArrayList<>();
    }

    public static TrackerStorage instance() {
        if (uniqueInstance == null)
            uniqueInstance = new TrackerStorage();
        return uniqueInstance;
    }

    public void update(ArrayList<String> list) {
        this.expenses = list;
    }

    public void add(String node) {
        expenses.add(node);
    }

    public ArrayList<String> getList() {
        return expenses;
    }

    public void delete() {
        expenses.clear();
        serialize();
    }

    public void serialize() {
        // Stores the pie chart
        try {
            FileOutputStream fileOut = new FileOutputStream(TRACKER_PATH);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(expenses);
            objOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> deserialize() {
        // Reads the pie chart
        try {
            FileInputStream fileIn = new FileInputStream(TRACKER_PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            expenses = (ArrayList<String>) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return expenses;
    }

}
