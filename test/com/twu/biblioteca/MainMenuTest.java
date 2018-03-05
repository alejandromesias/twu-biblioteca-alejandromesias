package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldReturnMenuOptions() {

        ArrayList<MenuOption> menuOptions ;

        menuOptions = MainMenu.getOptions();
        assertEquals("List Books", menuOptions.get(0).getOptionLabel());
        assertEquals("a", menuOptions.get(0).getOptionId());
    }
}
