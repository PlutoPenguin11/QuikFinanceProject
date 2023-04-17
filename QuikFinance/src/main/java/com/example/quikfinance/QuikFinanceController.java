package com.example.quikfinance;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

import java.text.BreakIterator;
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

    int housing;
    int transportation;
    int education;
    int groceries;
    int entertainment;
    int other;

    @FXML
    void amount1KeyTyped(KeyEvent event) {
        if (AmountTextField1.getText() == "") {
            BalanceTextField1.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField1.getText());
        double startingBalance = Double.parseDouble(StartingBalanceTextField.getText());
        double runningBalance = startingBalance - amount;
        String runningBalanceString = String.format("%.2f", runningBalance);
        BalanceTextField1.setText(String.valueOf(runningBalanceString));
    }

    @FXML
     void amount2KeyTyped(KeyEvent event) {
        if (AmountTextField2.getText() == "") {
            BalanceTextField2.setText("");
            return;
        }
        double amount = Double.parseDouble(AmountTextField2.getText());
        double startingBalance = Double.parseDouble(BalanceTextField1.getText());
        double runningBalance = startingBalance - amount;
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

        //checkCategory();
    }


    //-------------------SUMMARY SCREEN TEXT-----------------
    @FXML
    private MenuButton menu1;
    @FXML
    private MenuButton menu2;
    @FXML
    private MenuButton menu3;
    @FXML
    private MenuButton menu4;
    @FXML
    private MenuButton menu5;
    @FXML
    private MenuButton menu6;
    @FXML
    private MenuButton menu7;
    @FXML
    private MenuButton menu8;

    @FXML
    private Label sum2;

    public void checkCategory(){
    //System.out.println(menu8.getText());
    }
   // @FXML
    //void
}