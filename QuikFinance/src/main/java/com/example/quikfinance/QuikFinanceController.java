package com.example.quikfinance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

public class QuikFinanceController {
    @FXML
    private TextField AmountTextField1;
    @FXML
    private TextField AmountTextField2;
    @FXML
    private TextField AmountTextField3;
    @FXML
    private TextField AmountTextField4;
    @FXML
    private TextField AmountTextField5;
    @FXML
    private TextField AmountTextField6;
    @FXML
    private TextField AmountTextField7;
    @FXML
    private TextField AmountTextField8;
    @FXML
    private TextField BalanceTextField1;
    @FXML
    private TextField BalanceTextField2;
    @FXML
    private TextField BalanceTextField3;
    @FXML
    private TextField BalanceTextField4;
    @FXML
    private TextField BalanceTextField5;
    @FXML
    private TextField BalanceTextField6;
    @FXML
    private TextField BalanceTextField7;
    @FXML
    private TextField BalanceTextField8;
    @FXML
    private TextField DateTextField1;
    @FXML
    private TextField DateTextField2;
    @FXML
    private TextField DateTextField3;
    @FXML
    private TextField DateTextField4;
    @FXML
    private TextField DateTextField5;
    @FXML
    private TextField DateTextField6;
    @FXML
    private TextField DateTextField7;
    @FXML
    private TextField DateTextField8;
    @FXML
    private TextField DescriptionTextField1;
    @FXML
    private TextField DescriptionTextField2;
    @FXML
    private TextField DescriptionTextField3;
    @FXML
    private TextField DescriptionTextField4;
    @FXML
    private TextField DescriptionTextField5;
    @FXML
    private TextField DescriptionTextField6;
    @FXML
    private TextField DescriptionTextField7;
    @FXML
    private TextField DescriptionTextField8;
    @FXML
    private TextField StartingBalanceTextField;
    @FXML
    private ToggleGroup row1;
    @FXML
    private ToggleGroup row2;
    @FXML
    private ToggleGroup row3;
    @FXML
    private ToggleGroup row4;
    @FXML
    private ToggleGroup row5;

    private Transaction transaction1 = new Transaction();
    private Transaction transaction2 = new Transaction();
    private Transaction transaction3 = new Transaction();
    private Transaction transaction4 = new Transaction();
    private Transaction transaction5 = new Transaction();
    private Transaction transaction6 = new Transaction();
    private Transaction transaction7 = new Transaction();
    private Transaction transaction8 = new Transaction();
    private Transaction[] transactions = {transaction1, transaction2, transaction3, transaction4, transaction5, transaction6, transaction7, transaction8};

    @FXML
    void amount1KeyTyped(KeyEvent event) {
        transactions[0].setAmount(Double.parseDouble(AmountTextField1.getText()));
        if (AmountTextField1.getText() == "") {
            BalanceTextField1.setText("");
            return;
        }
        double startingBalance = Double.parseDouble(StartingBalanceTextField.getText());
        double runningBalance = startingBalance - transactions[0].amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField1.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amount2KeyTyped(KeyEvent event) {
        transactions[1].setAmount(Double.parseDouble(AmountTextField2.getText()));
        if (AmountTextField2.getText() == "") {
            BalanceTextField2.setText("");
            return;
        }
        double startingBalance = Double.parseDouble(StartingBalanceTextField.getText());
        double runningBalance = startingBalance - transactions[0].amount - transactions[1].amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField2.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amount3KeyTyped(KeyEvent event) {
        if (AmountTextField3.getText() == "") {
            BalanceTextField3.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField3.getText());
        double startingBalance = Double.parseDouble(BalanceTextField2.getText());
        double runningBalance = startingBalance - amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField3.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amount4KeyTyped(KeyEvent event) {
        if (AmountTextField4.getText() == "") {
            BalanceTextField4.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField4.getText());
        double startingBalance = Double.parseDouble(BalanceTextField3.getText());
        double runningBalance = startingBalance - amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField4.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amount5KeyTyped(KeyEvent event) {
        if (AmountTextField5.getText() == "") {
            BalanceTextField5.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField5.getText());
        double startingBalance = Double.parseDouble(BalanceTextField4.getText());
        double runningBalance = startingBalance - amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField5.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amount6KeyTyped(KeyEvent event) {
        if (AmountTextField6.getText() == "") {
            BalanceTextField6.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField6.getText());
        double startingBalance = Double.parseDouble(BalanceTextField5.getText());
        double runningBalance = startingBalance - amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField6.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amount7KeyTyped(KeyEvent event) {
        if (AmountTextField7.getText() == "") {
            BalanceTextField7.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField7.getText());
        double startingBalance = Double.parseDouble(BalanceTextField6.getText());
        double runningBalance = startingBalance - amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField7.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amount8KeyTyped(KeyEvent event) {
        if (AmountTextField8.getText() == "") {
            BalanceTextField8.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField8.getText());
        double startingBalance = Double.parseDouble(BalanceTextField7.getText());
        double runningBalance = startingBalance - amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField8.setText(String.valueOf(runningBalanceString));
    }

    @FXML
    void amountKeyTyped(KeyEvent event) {
        // Get the double value of the starting balance text field.
        double startingBalance = Double.parseDouble(StartingBalanceTextField.getText());

        // If the user clears an amount, set that amount's value within the object to zero.
        if (AmountTextField1.getText() == "")
            transactions[0].setAmount(0);
        if (AmountTextField2.getText() == "")
            transactions[1].setAmount(0);
        if (AmountTextField3.getText() == "")
            transactions[2].setAmount(0);
        if (AmountTextField4.getText() == "")
            transactions[3].setAmount(0);
        if (AmountTextField5.getText() == "")
            transactions[4].setAmount(0);
        if (AmountTextField6.getText() == "")
            transactions[5].setAmount(0);
        if (AmountTextField7.getText() == "")
            transactions[6].setAmount(0);
        if (AmountTextField8.getText() == "")
            transactions[7].setAmount(0);

        BalanceTextField1.setText(String.valueOf(startingBalance - transactions[0].getAmount());
        BalanceTextField2.setText(String.valueOf(startingBalance - transactions[0].getAmount() - transactions[1].getAmount());
        BalanceTextField3.setText(String.valueOf(startingBalance - transactions[0].getAmount() - transactions[1].getAmount() - transactions[2].getAmount());
        BalanceTextField4.setText(String.valueOf(startingBalance - transactions[0].getAmount());
        BalanceTextField5.setText(String.valueOf(startingBalance - transactions[0].getAmount());
        BalanceTextField6.setText(String.valueOf(startingBalance - transactions[0].getAmount());
        BalanceTextField7.setText(String.valueOf(startingBalance - transactions[0].getAmount());
        BalanceTextField8.setText(String.valueOf(startingBalance - transactions[0].getAmount());
        double runningBalance = startingBalance - transactions[0].amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField1.setText(String.valueOf(runningBalanceString));

        double startingBalance = Double.parseDouble(StartingBalanceTextField.getText());
        double runningBalance = startingBalance - transactions[0].amount - transactions[1].amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField2.setText(String.valueOf(startingBalance - transactions[0].getAmount()));
    }
}