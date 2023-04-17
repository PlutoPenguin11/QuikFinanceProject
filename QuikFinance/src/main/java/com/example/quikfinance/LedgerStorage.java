package com.example.quikfinance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class LedgerStorage {

    private final static String LEDGER_PATH = "QuikFinance/src/main/resources/com/example/quikfinance/ledger.ser";
    private final static String STARTING_BALANCE_PATH = "QuikFinance/src/main/resources/com/example/quikfinance/balance.ser";
    private String startingBalance;
    private Transaction[] transactionArray;
    private static LedgerStorage uniqueInstance = new LedgerStorage();

    private LedgerStorage() {
        transactionArray = new Transaction[8];
    }

    // For singleton design pattern. Enforces there only being 1 instance.
    public static LedgerStorage instance() {
        return uniqueInstance;
    }

    public void updateEquation(Transaction updatedTransaction, int index) {
        transactionArray[index] = updatedTransaction;
    }

    // Call when user makes a change to TextField
    public Boolean updateAll(Transaction[] transactions, String balance) {
        startingBalance = balance;
        if (transactions.length == 8)
            transactionArray = transactions;
        else
            return false;
        return true;
    }

    public Transaction[] getList() {
        return transactionArray;
    }

    public String getStartingBalance() {
        return startingBalance;
    }

    public void serialize() {
        // Stores all 8 transaction objjects
        try {
            FileOutputStream fileOut = new FileOutputStream(LEDGER_PATH);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(transactionArray);
            objOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Stores starting balance
        try {
            FileOutputStream fileOut = new FileOutputStream(STARTING_BALANCE_PATH);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(startingBalance);
            objOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize() {
        // Reads all 8 stored transaction objects
        try {
            FileInputStream fileIn = new FileInputStream(LEDGER_PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            transactionArray = (Transaction[]) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Reads stored starting balance
        try {
            FileInputStream fileIn = new FileInputStream(STARTING_BALANCE_PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            startingBalance = (String) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Transaction transaction : transactionArray) {
            if (transaction == null) {
                transaction = new Transaction();
            }
        }
    }

}
