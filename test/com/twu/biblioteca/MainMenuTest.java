package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldReturnMenuOptions() {

        String[] menuOptions ;

        menuOptions = MainMenu.getOptions();
        assertEquals("List Books", menuOptions[0]);
    }
}
