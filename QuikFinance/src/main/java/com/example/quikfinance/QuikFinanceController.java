package com.example.quikfinance;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.quikfinance.storage.LedgerStorage;
import com.example.quikfinance.storage.TrackerStorage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private ChoiceBox<String> CategoryChoiceBox1;
    @FXML
    private ChoiceBox<String> CategoryChoiceBox2;
    @FXML
    private ChoiceBox<String> CategoryChoiceBox3;
    @FXML
    private ChoiceBox<String> CategoryChoiceBox4;
    @FXML
    private ChoiceBox<String> CategoryChoiceBox5;
    @FXML
    private ChoiceBox<String> CategoryChoiceBox6;
    @FXML
    private ChoiceBox<String> CategoryChoiceBox7;
    @FXML
    private ChoiceBox<String> CategoryChoiceBox8;
    // Create an array of strings that will be the options in the drop-down category menu.
    private String[] category = {"Rent", "Utilities", "Groceries", "Transportation", "Entertainment", "Paycheck", "Other"};

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
    private LedgerStorage storage = LedgerStorage.instance();
    private TrackerStorage storedChart = TrackerStorage.instance();

    // Put these eight transaction objects into an array.
    private Transaction[] transactions;
    private TextField[] amountFields;
    private TextField[] dateFields;
    private TextField[] descriptionFields;
    private ToggleButton[] paidButtons;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        storage.deserialize();
        transactions = storage.getList();

        StartingBalanceTextField.setText(storage.getStartingBalance());

        // Organizes TextFields for reading storage, since we aren't using array lists.
        amountFields = new TextField[] { AmountTextField1, AmountTextField2, AmountTextField3, AmountTextField4,
                AmountTextField5, AmountTextField6, AmountTextField7, AmountTextField8 };
        dateFields = new TextField[] { DateTextField1, DateTextField2, DateTextField3, DateTextField4,
                DateTextField5, DateTextField6, DateTextField7, DateTextField8 };
        descriptionFields = new TextField[] { DescriptionTextField1, DescriptionTextField2, DescriptionTextField3,
                DescriptionTextField4, DescriptionTextField5, DescriptionTextField6, DescriptionTextField7, DescriptionTextField8 };
        paidButtons = new ToggleButton[] { PaidButton1, PaidButton2, PaidButton3, PaidButton4, PaidButton5, PaidButton6,
                PaidButton7, PaidButton8 };

        // Instantiates all null objects
        for (Transaction transaction : transactions) {
            if (transaction == null) {
                transaction = new Transaction();
            }
        }

        // Reads and fills in stored data
        for (int i = 0; i < 8; i++) {
            dateFields[i].setText(transactions[i].getDate());
            descriptionFields[i].setText(transactions[i].getDescription());
            paidButtons[i].setSelected(transactions[i].getStatus());
            amountFields[i].setText(Math.abs(transactions[i].getAmount()) + "");
        }

        // Updates running balance fields based on stored data
        amountKeyTyped(null);

        // Add the options to the ledger's category drop-down.
        CategoryChoiceBox1.getItems().addAll(category);
        CategoryChoiceBox2.getItems().addAll(category);
        CategoryChoiceBox3.getItems().addAll(category);
        CategoryChoiceBox4.getItems().addAll(category);
        CategoryChoiceBox5.getItems().addAll(category);
        CategoryChoiceBox6.getItems().addAll(category);
        CategoryChoiceBox7.getItems().addAll(category);
        CategoryChoiceBox8.getItems().addAll(category);

        // Update the object when the user takes action on the drop-down.
        CategoryChoiceBox1.setOnAction(this::updateCategoryWithinObject);
        CategoryChoiceBox2.setOnAction(this::updateCategoryWithinObject);
        CategoryChoiceBox3.setOnAction(this::updateCategoryWithinObject);
        CategoryChoiceBox4.setOnAction(this::updateCategoryWithinObject);
        CategoryChoiceBox5.setOnAction(this::updateCategoryWithinObject);
        CategoryChoiceBox6.setOnAction(this::updateCategoryWithinObject);
        CategoryChoiceBox7.setOnAction(this::updateCategoryWithinObject);
        CategoryChoiceBox8.setOnAction(this::updateCategoryWithinObject);

    }

    @FXML
    void updateCategoryWithinObject(ActionEvent event) {
        transactions[0].setCategory(CategoryChoiceBox1.getValue());
        transactions[1].setCategory(CategoryChoiceBox2.getValue());
        transactions[2].setCategory(CategoryChoiceBox3.getValue());
        transactions[3].setCategory(CategoryChoiceBox4.getValue());
        transactions[4].setCategory(CategoryChoiceBox5.getValue());
        transactions[5].setCategory(CategoryChoiceBox6.getValue());
        transactions[6].setCategory(CategoryChoiceBox7.getValue());
        transactions[7].setCategory(CategoryChoiceBox8.getValue());
    }

    // When the user types a description for the first transaction, update the
    // description that's stored in the object.
    @FXML
    void description1KeyTyped(KeyEvent event) {
        transactions[0].setDescription(DescriptionTextField1.getText());
        update();
    }

    // When the user types a description for the second transaction, update the
    // description that's stored in the object.
    @FXML
    void description2KeyTyped(KeyEvent event) {
        transactions[1].setDescription(DescriptionTextField2.getText());
        update();
    }

    // When the user types a description for the third transaction, update the
    // description that's stored in the object.
    @FXML
    void description3KeyTyped(KeyEvent event) {
        transactions[2].setDescription(DescriptionTextField3.getText());
        update();
    }

    // When the user types a description for the fourth transaction, update the
    // description that's stored in the object.
    @FXML
    void description4KeyTyped(KeyEvent event) {
        transactions[3].setDescription(DescriptionTextField4.getText());
        update();
    }

    // When the user types a description for the fifth transaction, update the
    // description that's stored in the object.
    @FXML
    void description5KeyTyped(KeyEvent event) {
        transactions[4].setDescription(DescriptionTextField5.getText());
        update();
    }

    // When the user types a description for the sixth transaction, update the
    // description that's stored in the object.
    @FXML
    void description6KeyTyped(KeyEvent event) {
        transactions[5].setDescription(DescriptionTextField6.getText());
        update();
    }

    // When the user types a description for the seventh transaction, update the
    // description that's stored in the object.
    @FXML
    void description7KeyTyped(KeyEvent event) {
        transactions[6].setDescription(DescriptionTextField7.getText());
        update();
    }

    // When the user types a description for the eighth transaction, update the
    // description that's stored in the object.
    @FXML
    void description8KeyTyped(KeyEvent event) {
        transactions[7].setDescription(DescriptionTextField8.getText());
        update();
    }

    // When the user types amounts for any transaction, update the running balance
    // for all transactions. Also update the amount that's stored in the object.
    @FXML
    void amountKeyTyped(KeyEvent event) {

        // Get the double value of the starting balance text field.
        double startingBalance = Double.parseDouble(StartingBalanceTextField.getText());

        // If the user clears the first transaction's amount, set the first transaction
        // object's amount to zero and update the display.
        if (AmountTextField1.getText() == "") {
            transactions[0].setAmount(0);
            BalanceTextField1.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[0].setStatus(PaidButton1.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[0].getStatus())
                transactions[0].setAmount(-Double.parseDouble(AmountTextField1.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[0].setAmount(Double.parseDouble(AmountTextField1.getText()));
        }

        // If the user clears the second transaction's amount, set the second
        // transaction object's amount to zero and update the display.
        if (AmountTextField2.getText() == "") {
            transactions[1].setAmount(0);
            BalanceTextField2.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[1].setStatus(PaidButton2.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[1].getStatus())
                transactions[1].setAmount(-Double.parseDouble(AmountTextField2.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[1].setAmount(Double.parseDouble(AmountTextField2.getText()));
        }

        // If the user clears the third transaction's amount, set the third transaction
        // object's amount to zero and update the display.
        if (AmountTextField3.getText() == "") {
            transactions[2].setAmount(0);
            BalanceTextField3.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[2].setStatus(PaidButton3.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[2].getStatus())
                transactions[2].setAmount(-Double.parseDouble(AmountTextField3.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[2].setAmount(Double.parseDouble(AmountTextField3.getText()));
        }

        // If the user clears the fourth transaction's amount, set the fourth
        // transaction object's amount to zero and update the display.
        if (AmountTextField4.getText() == "") {
            transactions[3].setAmount(0);
            BalanceTextField4.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[3].setStatus(PaidButton4.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[3].getStatus())
                transactions[3].setAmount(-Double.parseDouble(AmountTextField4.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[3].setAmount(Double.parseDouble(AmountTextField4.getText()));
        }

        // If the user clears the fifth transaction's amount, set the fifth transaction
        // object's amount to zero and update the display.
        if (AmountTextField5.getText() == "") {
            transactions[4].setAmount(0);
            BalanceTextField5.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[4].setStatus(PaidButton5.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[4].getStatus())
                transactions[4].setAmount(-Double.parseDouble(AmountTextField5.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[4].setAmount(Double.parseDouble(AmountTextField5.getText()));
        }

        // If the user clears the sixth transaction's amount, set the sixth transaction
        // object's amount to zero and update the display.
        if (AmountTextField6.getText() == "") {
            transactions[5].setAmount(0);
            BalanceTextField6.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[5].setStatus(PaidButton6.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[5].getStatus())
                transactions[5].setAmount(-Double.parseDouble(AmountTextField6.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[5].setAmount(Double.parseDouble(AmountTextField6.getText()));
        }

        // If the user clears the seventh transaction's amount, set the seventh
        // transaction object's amount to zero and update the display.
        if (AmountTextField7.getText() == "") {
            transactions[6].setAmount(0);
            BalanceTextField7.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[6].setStatus(PaidButton7.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[6].getStatus())
                transactions[6].setAmount(-Double.parseDouble(AmountTextField7.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[6].setAmount(Double.parseDouble(AmountTextField7.getText()));
        }

        // If the user clears the eighth transaction's amount, set the eighth
        // transaction object's amount to zero and update the display.
        if (AmountTextField8.getText() == "") {
            transactions[7].setAmount(0);
            BalanceTextField8.setText("");
        } else {
            // If the user enters an amount, determine whether it was paid.
            transactions[7].setStatus(PaidButton8.isSelected());
            // If it was paid, set the object's amount equal to the negative of the amount
            // the user entered.
            if (transactions[7].getStatus())
                transactions[7].setAmount(-Double.parseDouble(AmountTextField8.getText()));
            // If it was not paid, set the object's amount equal to the positive amount the
            // user entered.
            else
                transactions[7].setAmount(Double.parseDouble(AmountTextField8.getText()));
        }

        // Display the first row's running balance, but only if the user has entered an
        // amount for that row.
        double firstRunningBalance = startingBalance + transactions[0].getAmount();
        String formattedFirstRunningBalance = String.format("$%.2f", firstRunningBalance);
        if (AmountTextField1.getText() != "")
            BalanceTextField1.setText(formattedFirstRunningBalance);

        // Display the second row's running balance, but only if the user has entered an
        // amount for that row.
        double secondRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount();
        String formattedSecondRunningBalance = String.format("$%.2f", secondRunningBalance);
        if (AmountTextField2.getText() != "")
            BalanceTextField2.setText(formattedSecondRunningBalance);

        // Display the third row's running balance, but only if the user has entered an
        // amount for that row.
        double thirdRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount()
                + transactions[2].getAmount();
        String formattedThirdRunningBalance = String.format("$%.2f", thirdRunningBalance);
        if (AmountTextField3.getText() != "")
            BalanceTextField3.setText(formattedThirdRunningBalance);

        // Display the fourth row's running balance, but only if the user has entered an
        // amount for that row.
        double fourthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount()
                + transactions[2].getAmount() + transactions[3].getAmount();
        String formattedFourthRunningBalance = String.format("$%.2f", fourthRunningBalance);
        if (AmountTextField4.getText() != "")
            BalanceTextField4.setText(formattedFourthRunningBalance);

        // Display the fifth row's running balance, but only if the user has entered an
        // amount for that row.
        double fifthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount()
                + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount();
        String formattedFifthRunningBalance = String.format("$%.2f", fifthRunningBalance);
        if (AmountTextField5.getText() != "")
            BalanceTextField5.setText(formattedFifthRunningBalance);

        // Display the sixth row's running balance, but only if the user has entered an
        // amount for that row.
        double sixthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount()
                + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount()
                + transactions[5].getAmount();
        String formattedSixthRunningBalance = String.format("$%.2f", sixthRunningBalance);
        if (AmountTextField6.getText() != "")
            BalanceTextField6.setText(formattedSixthRunningBalance);

        // Display the seventh row's running balance, but only if the user has entered
        // an amount for that row.
        double seventhRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount()
                + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount()
                + transactions[5].getAmount() + transactions[6].getAmount();
        String formattedSeventhRunningBalance = String.format("$%.2f", seventhRunningBalance);
        if (AmountTextField7.getText() != "")
            BalanceTextField7.setText(formattedSeventhRunningBalance);

        // Display the eighth row's running balance, but only if the user has entered an
        // amount for that row.
        double eighthRunningBalance = startingBalance + transactions[0].getAmount() + transactions[1].getAmount()
                + transactions[2].getAmount() + transactions[3].getAmount() + transactions[4].getAmount()
                + transactions[5].getAmount() + transactions[6].getAmount() + transactions[7].getAmount();
        String formattedEighthRunningBalance = String.format("$%.2f", eighthRunningBalance);
        if (AmountTextField8.getText() != "")
            BalanceTextField8.setText(formattedEighthRunningBalance);

        update();
    }

    // When the user types a date for the first transaction, update the date that's
    // stored in the object.
    @FXML
    void date1KeyTyped(KeyEvent event) {
        transactions[0].setDate(DateTextField1.getText());
        update();
    }

    // When the user types a date for the second transaction, update the date that's
    // stored in the object.
    @FXML
    void date2KeyTyped(KeyEvent event) {
        transactions[1].setDate(DateTextField2.getText());
        update();
    }

    // When the user types a date for the third transaction, update the date that's
    // stored in the object.
    @FXML
    void date3KeyTyped(KeyEvent event) {
        transactions[2].setDate(DateTextField3.getText());
        update();
    }

    // When the user types a date for the fourth transaction, update the date that's
    // stored in the object.
    @FXML
    void date4KeyTyped(KeyEvent event) {
        transactions[3].setDate(DateTextField4.getText());
        update();
    }

    // When the user types a date for the fifth transaction, update the date that's
    // stored in the object.
    @FXML
    void date5KeyTyped(KeyEvent event) {
        transactions[4].setDate(DateTextField5.getText());
        update();
    }

    // When the user types a date for the sixth transaction, update the date that's
    // stored in the object.
    @FXML
    void date6KeyTyped(KeyEvent event) {
        transactions[5].setDate(DateTextField6.getText());
        update();
    }

    // When the user types a date for the seventh transaction, update the date
    // that's stored in the object.
    @FXML
    void date7KeyTyped(KeyEvent event) {
        transactions[6].setDate(DateTextField7.getText());
        update();
    }

    // When the user types a date for the eighth transaction, update the date that's
    // stored in the object.
    @FXML
    void date8KeyTyped(KeyEvent event) {
        transactions[7].setDate(DateTextField8.getText());
        update();
    }

    @FXML
    void paidButtonHit() {
        amountKeyTyped(null);
    }

    @FXML
    void showExpenseTracker() {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        expenseTracker.start(new Stage());
    }

    @FXML
    void showInterestCalculator() {
        InterestCalculator interestCalculator = new InterestCalculator();
        interestCalculator.start(new Stage());
    }

    @FXML
    void clearExpenseTracker() {
        storedChart.delete();
    }

    @FXML
    void startingBalanceKeyTyped(KeyEvent event) {
        amountKeyTyped(null);
    }

    @FXML
    private void update() {
        storage.updateAll(transactions, StartingBalanceTextField.getText());
        storage.serialize();
    }

    @FXML
    void clearLedger(){
        System.out.println("ledger cleared");
        AmountTextField1.setText("0");
        AmountTextField2.setText("0");
        AmountTextField3.setText("0");
        AmountTextField4.setText("0");
        AmountTextField5.setText("0");
        AmountTextField6.setText("0");
        AmountTextField7.setText("0");
        AmountTextField8.setText("0");
        BalanceTextField1.setText("");
        BalanceTextField2.setText("");
        BalanceTextField3.setText("");
        BalanceTextField4.setText("");
        BalanceTextField5.setText("");
        BalanceTextField6.setText("");
        BalanceTextField7.setText("");
        BalanceTextField8.setText("");
        DateTextField1.setText("");
        DateTextField2.setText("");
        DateTextField3.setText("");
        DateTextField4.setText("");
        DateTextField5.setText("");
        DateTextField6.setText("");
        DateTextField7.setText("");
        DateTextField8.setText("");
        DescriptionTextField1.setText("");
        DescriptionTextField2.setText("");
        DescriptionTextField3.setText("");
        DescriptionTextField4.setText("");
        DescriptionTextField5.setText("");
        DescriptionTextField6.setText("");
        DescriptionTextField7.setText("");
        DescriptionTextField8.setText("");
        update();


    }

    // Still needed:
    // In the GUI, implement the date as a drop-down selection.
    // In the GUI, implement the category menu so that once the user selects a
    // category, the GUI displays that category instead of the word "Category".
}