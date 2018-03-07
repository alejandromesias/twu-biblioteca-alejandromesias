package com.twu.biblioteca;

import org.junit.Assert;
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
        assertEquals("Check out book", menuOptions.get(1).getOptionLabel());
        assertEquals("b", menuOptions.get(1).getOptionId());
        assertEquals("Return book", menuOptions.get(2).getOptionLabel());
        assertEquals("c", menuOptions.get(2).getOptionId());

    }

    @Test
    public void shouldReturnTheOptionLabelByItsID() {

        String selectedOptionId = "a";
        String gottenOptionLabel = MainMenu.retrieveOption(selectedOptionId);

        Assert.assertEquals("List Books", gottenOptionLabel);

        selectedOptionId = "b";
        gottenOptionLabel = MainMenu.retrieveOption(selectedOptionId);

        Assert.assertEquals("Check out book", gottenOptionLabel);

        selectedOptionId = "c";
        gottenOptionLabel = MainMenu.retrieveOption(selectedOptionId);

        Assert.assertEquals("Return book", gottenOptionLabel);

    }
}
