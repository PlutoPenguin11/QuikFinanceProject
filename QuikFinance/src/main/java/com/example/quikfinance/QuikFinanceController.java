package com.example.quikfinance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class QuikFinanceController implements Initializable {

    // Initialize the functional parts of the graphical user interface.
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
    @FXML
    private ToggleButton PaidButton1;
    @FXML
    private ToggleButton PaidButton2;
    @FXML
    private ToggleButton PaidButton3;
    @FXML
    private ToggleButton PaidButton4;
    @FXML
    private ToggleButton PaidButton5;
    @FXML
    private ToggleButton PaidButton6;
    @FXML
    private ToggleButton PaidButton7;
    @FXML
    private ToggleButton PaidButton8;
    @FXML
    private ToggleButton UpdateButton;

    // Initialize eight transaction objects.
    private Storage storage = Storage.instance();

    // Put these eight transaction objects into an array.
    private Transaction[] transactions;
    private TextField[] amountFields;
    private TextField[] dateFields;
    private TextField[] descriptionFields;
    private ToggleButton[] paidButtons;

    @FXML @Override
    public void initialize(URL url, ResourceBundle rb) {
        storage.deserialize();
        transactions = storage.getList();

        StartingBalanceTextField.setText(storage.getStartingBalance());

        amountFields = new TextField[] { AmountTextField1, AmountTextField2, AmountTextField3, AmountTextField4,
                                         AmountTextField5, AmountTextField6, AmountTextField7, AmountTextField8 };
        dateFields = new TextField[] { DateTextField1, DateTextField2, DateTextField3, DateTextField4,
                                       DateTextField5, DateTextField6, DateTextField7, DateTextField8 };
        descriptionFields = new TextField[] { DescriptionTextField1, DescriptionTextField2, DescriptionTextField3, DescriptionTextField4, 
                                              DescriptionTextField5, DescriptionTextField6, DescriptionTextField7, DescriptionTextField8 };
        paidButtons = new ToggleButton[] { PaidButton1, PaidButton2, PaidButton3, PaidButton4, PaidButton5, PaidButton6, PaidButton7, PaidButton8 };

        for (Transaction transaction : transactions) {
            if (transaction == null) {
                transaction = new Transaction();
            }
        }

        for (int i = 0; i < 8; i++) {
            dateFields[i].setText(transactions[i].getDate());
            descriptionFields[i].setText(transactions[i].getDescription());
            paidButtons[i].setSelected(transactions[i].getStatus());
            amountFields[i].setText(Math.abs(transactions[i].getAmount())+"");
        }

        amountKeyTyped(null);
    }

    // When the user types a description for the first transaction, update the description that's stored in the object.
    @FXML
    void description1KeyTyped(KeyEvent event) {
        transactions[0].setDescription(DescriptionTextField1.getText());
        update();
    }

    // When the user types a description for the second transaction, update the description that's stored in the object.
    @FXML
    void description2KeyTyped(KeyEvent event) {
        transactions[1].setDescription(DescriptionTextField2.getText());
        update();
    }

    // When the user types a description for the third transaction, update the description that's stored in the object.
    @FXML
    void description3KeyTyped(KeyEvent event) {
        transactions[2].setDescription(DescriptionTextField3.getText());
        update();
    }

    // When the user types a description for the fourth transaction, update the description that's stored in the object.
    @FXML
    void description4KeyTyped(KeyEvent event) {
        transactions[3].setDescription(DescriptionTextField4.getText());
        update();
    }

    // When the user types a description for the fifth transaction, update the description that's stored in the object.
    @FXML
    void description5KeyTyped(KeyEvent event) {
        transactions[4].setDescription(DescriptionTextField5.getText());
        update();
    }

    // When the user types a description for the sixth transaction, update the description that's stored in the object.
    @FXML
    void description6KeyTyped(KeyEvent event) {
        transactions[5].setDescription(DescriptionTextField6.getText());
        update();
    }

    // When the user types a description for the seventh transaction, update the description that's stored in the object.
    @FXML
    void description7KeyTyped(KeyEvent event) {
        transactions[6].setDescription(DescriptionTextField7.getText());
        update();
    }

    // When the user types a description for the eighth transaction, update the description that's stored in the object.
    @FXML
    void description8KeyTyped(KeyEvent event) {
        transactions[7].setDescription(DescriptionTextField8.getText());
        update();
    }

    // When the user types amounts for any transaction, update the running balance for all transactions. Also update the amount that's stored in the object.
    @FXML
    void amountKeyTyped(KeyEvent event) {

        // Get the double value of the starting balance text field.
        double startingBalance = Double.parseDouble(StartingBalanceTextField.getText());



        // If the user clears the first transaction's amount, set the first transaction object's amount to zero and update the display.
        if (AmountTextField1.getText() == "") {
            transactions[0].setAmount(0);
            BalanceTextField1.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[0].setStatus(PaidButton1.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[0].getStatus()) transactions[0].setAmount(- Double.parseDouble(AmountTextField1.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[0].setAmount(Double.parseDouble(AmountTextField1.getText()));
        }

        // If the user clears the second transaction's amount, set the second transaction object's amount to zero and update the display.
        if (AmountTextField2.getText() == "") {
            transactions[1].setAmount(0);
            BalanceTextField2.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[1].setStatus(PaidButton2.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[1].getStatus()) transactions[1].setAmount(- Double.parseDouble(AmountTextField2.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[1].setAmount(Double.parseDouble(AmountTextField2.getText()));
        }

        // If the user clears the third transaction's amount, set the third transaction object's amount to zero and update the display.
        if (AmountTextField3.getText() == "") {
            transactions[2].setAmount(0);
            BalanceTextField3.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[2].setStatus(PaidButton3.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[2].getStatus()) transactions[2].setAmount(- Double.parseDouble(AmountTextField3.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[2].setAmount(Double.parseDouble(AmountTextField3.getText()));
        }

        // If the user clears the fourth transaction's amount, set the fourth transaction object's amount to zero and update the display.
        if (AmountTextField4.getText() == "") {
            transactions[3].setAmount(0);
            BalanceTextField4.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[3].setStatus(PaidButton4.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[3].getStatus()) transactions[3].setAmount(- Double.parseDouble(AmountTextField4.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[3].setAmount(Double.parseDouble(AmountTextField4.getText()));
        }

        // If the user clears the fifth transaction's amount, set the fifth transaction object's amount to zero and update the display.
        if (AmountTextField5.getText() == "") {
            transactions[4].setAmount(0);
            BalanceTextField5.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[4].setStatus(PaidButton5.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[4].getStatus()) transactions[4].setAmount(- Double.parseDouble(AmountTextField5.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[4].setAmount(Double.parseDouble(AmountTextField5.getText()));
        }

        // If the user clears the sixth transaction's amount, set the sixth transaction object's amount to zero and update the display.
        if (AmountTextField6.getText() == "") {
            transactions[5].setAmount(0);
            BalanceTextField6.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[5].setStatus(PaidButton6.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[5].getStatus()) transactions[5].setAmount(- Double.parseDouble(AmountTextField6.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[5].setAmount(Double.parseDouble(AmountTextField6.getText()));
        }

        // If the user clears the seventh transaction's amount, set the seventh transaction object's amount to zero and update the display.
        if (AmountTextField7.getText() == "") {
            transactions[6].setAmount(0);
            BalanceTextField7.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[6].setStatus(PaidButton7.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[6].getStatus()) transactions[6].setAmount(- Double.parseDouble(AmountTextField7.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[6].setAmount(Double.parseDouble(AmountTextField7.getText()));
        }

        // If the user clears the eighth transaction's amount, set the eighth transaction object's amount to zero and update the display.
        if (AmountTextField8.getText() == "") {
            transactions[7].setAmount(0);
            BalanceTextField8.setText("");
        }
        else {
            // If the user enters an amount, determine whether it was paid.
            transactions[7].setStatus(PaidButton8.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount the user entered.
            if (transactions[7].getStatus()) transactions[7].setAmount(- Double.parseDouble(AmountTextField8.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the user entered.
            else transactions[7].setAmount(Double.parseDouble(AmountTextField8.getText()));
        }



        // Display the first row's running balance, but only if the user has entered an amount for that row.
        double firstRunningBalance = startingBalance + transactions[0].getAmount();
        String formattedFirstRunningBalance = String.format("$%.2f", firstRunningBalance);
        if (AmountTextField1.getText() != "")
            BalanceTextField1.setText(formattedFirstRunningBalance);

        // Display the second row's running balance, but only if the user has entered an amount for that row.
        double secondRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount();
        String formattedSecondRunningBalance = String.format("$%.2f", secondRunningBalance);
        if (AmountTextField2.getText() != "")
            BalanceTextField2.setText(formattedSecondRunningBalance);

        // Display the third row's running balance, but only if the user has entered an amount for that row.
        double thirdRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount() + transactions[2].getAmount();
        String formattedThirdRunningBalance = String.format("$%.2f", thirdRunningBalance);
        if (AmountTextField3.getText() != "")
            BalanceTextField3.setText(formattedThirdRunningBalance);

        // Display the fourth row's running balance, but only if the user has entered an amount for that row.
        double fourthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount() + transactions[2].getAmount() + transactions[3].getAmount();
        String formattedFourthRunningBalance = String.format("$%.2f", fourthRunningBalance);
        if (AmountTextField4.getText() != "")
            BalanceTextField4.setText(formattedFourthRunningBalance);

        // Display the fifth row's running balance, but only if the user has entered an amount for that row.
        double fifthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount() + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount();
        String formattedFifthRunningBalance = String.format("$%.2f", fifthRunningBalance);
        if (AmountTextField5.getText() != "")
            BalanceTextField5.setText(formattedFifthRunningBalance);

        // Display the sixth row's running balance, but only if the user has entered an amount for that row.
        double sixthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount() + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount() + transactions[5].getAmount();
        String formattedSixthRunningBalance = String.format("$%.2f", sixthRunningBalance);
        if (AmountTextField6.getText() != "")
            BalanceTextField6.setText(formattedSixthRunningBalance);

        // Display the seventh row's running balance, but only if the user has entered an amount for that row.
        double seventhRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount() + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount() + transactions[5].getAmount() + transactions[6].getAmount();
        String formattedSeventhRunningBalance = String.format("$%.2f", seventhRunningBalance);
        if (AmountTextField7.getText() != "")
            BalanceTextField7.setText(formattedSeventhRunningBalance);

        // Display the eighth row's running balance, but only if the user has entered an amount for that row.
        double eighthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount() + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount() + transactions[5].getAmount() + transactions[6].getAmount() + transactions[7].getAmount();
        String formattedEighthRunningBalance = String.format("$%.2f", eighthRunningBalance);
        if (AmountTextField8.getText() != "")
            BalanceTextField8.setText(formattedEighthRunningBalance);

        update();
    }

    
    // When the user types a date for the first transaction, update the date that's stored in the object.
    @FXML
    void date1KeyTyped(KeyEvent event) {
        transactions[0].setDate(DateTextField1.getText());
        update();
    }

    // When the user types a date for the second transaction, update the date that's stored in the object.
    @FXML
    void date2KeyTyped(KeyEvent event) {
        transactions[1].setDate(DateTextField2.getText());
        update();
    }

    // When the user types a date for the third transaction, update the date that's stored in the object.
    @FXML
    void date3KeyTyped(KeyEvent event) {
        transactions[2].setDate(DateTextField3.getText());
        update();
    }

    // When the user types a date for the fourth transaction, update the date that's stored in the object.
    @FXML
    void date4KeyTyped(KeyEvent event) {
        transactions[3].setDate(DateTextField4.getText());
        update();
    }

    // When the user types a date for the fifth transaction, update the date that's stored in the object.
    @FXML
    void date5KeyTyped(KeyEvent event) {
        transactions[4].setDate(DateTextField5.getText());
        update();
    }

    // When the user types a date for the sixth transaction, update the date that's stored in the object.
    @FXML
    void date6KeyTyped(KeyEvent event) {
        transactions[5].setDate(DateTextField6.getText());
        update();
    }

    // When the user types a date for the seventh transaction, update the date that's stored in the object.
    @FXML
    void date7KeyTyped(KeyEvent event) {
        transactions[6].setDate(DateTextField7.getText());
        update();
    }

    // When the user types a date for the eighth transaction, update the date that's stored in the object.
    @FXML
    void date8KeyTyped(KeyEvent event) {
        transactions[7].setDate(DateTextField8.getText());
        update();
    }

    @FXML
    private void update() {
        storage.updateAll(transactions, StartingBalanceTextField.getText());
        storage.serialize();
    }

    // Still needed:
    // In the GUI, implement the date as a drop-down selection.
    // Behind the scenes, update the transaction objects' dates.
    // In the GUI, implement the category menu so that once the user selects a category, the GUI displays that category instead of the word "Category".
    // Behind the scenes, update the transaction objects' categories.
    // Behind the scenes, write the transactions' attributes to a file so that they're stored between runs.
}