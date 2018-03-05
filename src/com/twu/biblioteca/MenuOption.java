package com.twu.biblioteca;

public class MenuOption {

    String optionLabel;
    String optionId;

    public MenuOption(String optionLabel, String optionId) {
        this.optionLabel = optionLabel;
        this.optionId = optionId;
    }

    public String getOptionLabel() {
        return this.optionLabel;
    }

    public String getOptionId() {
        return this.optionId;
    }

}
