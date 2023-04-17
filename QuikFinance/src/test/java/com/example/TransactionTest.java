package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.quikfinance.*;

public class TransactionTest {

    Transaction transaction;
    Category category1;
    Category category2;

    @BeforeEach
    public void setUp() {
        category1 = new Category(1, "Groceries");
        category2 = new Category(2, "Taxes");
        //transaction = new Transaction(category1, 50000, "10/12/1998", true);
    }

    @AfterEach
    public void tearDown() {
        category1 = category2 = null;
        transaction = null;
    }

    @Test
    public void checkCategory() {
        assertEquals("Groceries", transaction.getCategory().getCategory());
        assertEquals(1, transaction.getCategory().getID());
    }

    @Test
    public void changeCategory() {
        transaction.setCategory(category2);
        assertEquals("Taxes", transaction.getCategory().getCategory());
        assertEquals(2, transaction.getCategory().getID());
    }

    @Test
    public void changeDate() {
        String newDate = "10/12/2020";
        transaction.setDate(newDate);
        assertEquals(newDate, transaction.getDate());
    }

    @Test
    public void changeStatus() {
        transaction.setStatus(false);
        assertFalse(transaction.getStatus());
        transaction.setStatus(true);
        assertTrue(transaction.getStatus());
    }

    @Test
    public void changeDescription() {
        String description = "Apples";
        transaction.setDescription(description);
        assertEquals(description, transaction.getDescription());
    }

}
