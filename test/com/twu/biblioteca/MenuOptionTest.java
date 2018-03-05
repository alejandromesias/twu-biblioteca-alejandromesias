package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuOptionTest {

    @Test
    public void shouldHaveCreatedANewMenuOption() {
        MenuOption anOption = new MenuOption("labelForOption", "X");

        assertEquals("labelForOption", anOption.getOptionLabel());
        assertEquals("X", anOption.getOptionId());
    }

}
