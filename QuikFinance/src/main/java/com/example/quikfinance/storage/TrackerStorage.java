package com.example.quikfinance.storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.scene.chart.PieChart;

public class TrackerStorage {
    private final static String TRACKER_PATH = "QuikFinance/src/main/resources/com/example/quikfinance/tracker.ser";
    private static TrackerStorage uniqueInstance;
    private PieChart chart;

    private TrackerStorage() {
        chart = new PieChart();
    }

    public static TrackerStorage instance() {
        if (uniqueInstance == null)
            uniqueInstance = new TrackerStorage();
        return uniqueInstance;
    }

    public void update(PieChart chart) {
        this.chart = chart;
    }

    public PieChart getChart() {
        return chart;
    }

    public void delete() {
        chart = new PieChart();
        serialize();
    }

    public void serialize() {
        // Stores the pie chart
        try {
            FileOutputStream fileOut = new FileOutputStream(TRACKER_PATH);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(chart);
            objOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PieChart deserialize() {
        // Reads the pie chart
        try {
            FileInputStream fileIn = new FileInputStream(TRACKER_PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            chart = (PieChart) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return chart;
    }

}
