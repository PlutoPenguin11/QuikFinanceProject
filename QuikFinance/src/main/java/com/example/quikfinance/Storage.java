package com.example.quikfinance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Storage {

    private final static String FILE_PATH = "QuikFinance/src/main/resources/com/example/quikfinance/ledger.ser";
    private Transaction[] transactionArray;
    private static Storage uniqueInstance = new Storage();

    private Storage() {
        transactionArray = new Transaction[8];
    }

    public static Storage instance() {
        return uniqueInstance;
    }

    public void updateEquation(Transaction updatedTransaction, int index) {
        transactionArray[index] = updatedTransaction;
    }

    public Boolean updateAll(Transaction[] transactions) {
        if (transactions.length == 8)
            transactionArray = transactions;
        else
            return false;
        return true;
    }

    public Transaction[] getList() {
        return transactionArray;
    }

    public void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(transactionArray);
            objOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize() {
        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            transactionArray = (Transaction[]) objIn.readObject();
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
