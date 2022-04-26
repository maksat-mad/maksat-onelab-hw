package com.onelab.task.patterns.decorator.decorators;

import com.onelab.task.patterns.decorator.BookDecorator;
import com.onelab.task.patterns.decorator.MyBook;

public class YellowPageDecorator extends BookDecorator {


    private final MyBook myBook;

    public YellowPageDecorator(MyBook myBook){
        this.myBook = myBook;
    }

    @Override
    public String getDesc() {
        return myBook.getDesc() + "\n Your book's pages are YELLOW";
    }

}
