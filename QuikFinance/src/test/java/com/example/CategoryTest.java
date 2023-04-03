package com.example;

import org.junit.jupiter.api.*;

import com.example.quikfinance.CategoryClass;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    CategoryClass category;

    @BeforeEach
    public void setUp() {
        category = new CategoryClass(0, "Housing");
    }

    @AfterEach
    public void tearDown() {
        category = null;
    }

    @Test
    public void checkConstructor() {
        assertFalse(category == null);
        assertEquals(0, category.getID());
        assertEquals("Housing", category.getCategory());
    }

    @Test
    public void changeCategory() {
        String newCategory = "Groceries";
        category.setItemCategory(newCategory);
        assertEquals(newCategory, category.getCategory());
    }

    @Test
    public void changeID() {
        int newID = 1;
        category.setID(newID);
        assertEquals(newID, category.getID());
    }

    @Test
    public void checkPrice() {
        assertEquals(0, category.getPrice());

        category.setPrice(500);
        assertEquals(500, category.getPrice());

        //category.updatePrice(100);
        //assertEquals(600, category.getPrice());
    }
    
}
