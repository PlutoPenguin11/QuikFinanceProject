package com.example.quikfinance;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;

public class ExpenseTracker extends Application {

    // Define the UI components
    private TextField expenseField = new TextField();
    private ComboBox<String> categoryComboBox = new ComboBox<>();
    private DatePicker datePicker = new DatePicker(LocalDate.now());
    private Button addButton = new Button("Add Expense");
    private ListView<String> expenseListView = new ListView<>();
    private ObservableList<String> expenseList = FXCollections.observableArrayList();
    private PieChart pieChart = new PieChart();

    // Define the categories
    private final String[] categories = { "Food", "Transportation", "Housing", "Entertainment", "Utilities", "Other" };

    @Override
    public void start(Stage primaryStage) {

        // Set up the UI
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Add the expense field
        gridPane.add(new Label("Expense:"), 0, 0);
        gridPane.add(expenseField, 1, 0);

        // Add the category combo box
        gridPane.add(new Label("Category:"), 0, 1);
        categoryComboBox.getItems().addAll(categories);
        categoryComboBox.setValue(categories[0]);
        gridPane.add(categoryComboBox, 1, 1);

        // Add the date picker
        gridPane.add(new Label("Date:"), 0, 2);
        gridPane.add(datePicker, 1, 2);

        // Add the add button
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(addButton);
        gridPane.add(hBox, 1, 3);

        // Add the expense list view
        expenseListView.setItems(expenseList);
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(new Label("Expenses:"), expenseListView);
        gridPane.add(vBox, 2, 0, 1, 4);

        // Add the pie chart
        VBox chartBox = new VBox();
        chartBox.setSpacing(10);
        chartBox.getChildren().addAll(new Label("Expenses by Category:"), pieChart);
        gridPane.add(chartBox, 0, 4, 3, 1);

        // Set up the button event handler
        addButton.setOnAction(event -> {
            // Get the expense details
            String expense = expenseField.getText();
            String category = categoryComboBox.getValue();
            LocalDate date = datePicker.getValue();

            // Add the expense to the list
            expenseList.add(expense + " - " + category + " - " + date);

            // Update the pie chart
            updatePieChart();

            // Clear the input fields
            expenseField.clear();
            categoryComboBox.setValue(categories[0]);
            datePicker.setValue(LocalDate.now());
        });

        // Create the scene
        Scene scene = new Scene(gridPane, 800, 600);

        // Set the stage title and scene
        primaryStage.setTitle("Expense Tracker");
        primaryStage.setScene(scene);
        // Show the stage
        primaryStage.show();

    }

    // Update the pie chart with the current expenses
    // Update the pie chart with the current expenses
    private void updatePieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        double totalAmount = 0.0;
        for (String category : categories) {
            double categoryAmount = 0.0;
            for (String expense : expenseList) {
                String[] parts = expense.split(" - ");
                if (parts[1].equals(category)) {
                    try {
                        categoryAmount += Double.parseDouble(parts[0]);
                    } catch (NumberFormatException e) {
                        // Ignore expenses that have invalid amounts
                    }
                }
            }
            if (categoryAmount > 0) {
                totalAmount += categoryAmount;
                pieChartData.add(new PieChart.Data(category + " - " + categoryAmount, categoryAmount));
            }
        }
        for (PieChart.Data data : pieChartData) {
            data.setName(data.getName() + " (" + String.format("%.2f", data.getPieValue() / totalAmount * 100) + "%)"); // Add
                                                                                                                        // percentage
                                                                                                                        // to
                                                                                                                        // category
                                                                                                                        // name
            data.setPieValue(data.getPieValue() / totalAmount * 100); // Convert to percentage
        }
        pieChart.setData(pieChartData);
    }

    public static void main(String[] args) {
        launch(args);
    }

}