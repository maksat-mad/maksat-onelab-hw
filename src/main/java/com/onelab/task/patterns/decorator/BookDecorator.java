package com.onelab.task.patterns.decorator;

public abstract class BookDecorator implements MyBook {

    @Override
    public String getDesc() {
        return "This is your decorated book :) ";
    }
}
