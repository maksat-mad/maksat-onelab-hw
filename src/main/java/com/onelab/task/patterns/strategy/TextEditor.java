package com.onelab.task.patterns.strategy;

public class TextEditor {

    private final TextFormatter textFormatter;

    public TextEditor(TextFormatter textFormatter){
        this.textFormatter = textFormatter;
    }

    public void logText(String text){
        textFormatter.format(text);
    }
}
