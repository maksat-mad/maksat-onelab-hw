package com.onelab.task.patterns.decorator.decorators;

import com.onelab.task.patterns.decorator.BookDecorator;
import com.onelab.task.patterns.decorator.MyBook;

public class BigBookDecorator extends BookDecorator {

    private final MyBook myBook;

    public BigBookDecorator(MyBook myBook){
        this.myBook = myBook;
    }

    @Override
    public String getDesc() {
        return myBook.getDesc() + "\n Your book is BIG";
    }
}
