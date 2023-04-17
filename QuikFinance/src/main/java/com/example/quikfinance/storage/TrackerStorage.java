package com.example.quikfinance.storage;

import javafx.scene.chart.PieChart;

public class TrackerStorage {
    private final static String TRACKER_PATH = "QuikFinance/src/main/resources/com/example/quikfinance/tracker.ser";
    private static TrackerStorage uniqueInstance;
    private PieChart pieChart = new PieChart();

    private TrackerStorage() {

    }

    public static TrackerStorage instance() {
        if (uniqueInstance == null)
            uniqueInstance = new TrackerStorage();
        return uniqueInstance;
    }
}
