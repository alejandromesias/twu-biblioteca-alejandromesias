package com.twu.biblioteca.Types;

public class MenuOption {

    private String optionLabel;
    private String optionId;

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
