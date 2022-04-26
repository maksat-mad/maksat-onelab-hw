package com.onelab.task.patterns.decorator.decorators;

import com.onelab.task.patterns.decorator.MyBook;

public class SoftCoverBook implements MyBook {
    @Override
    public String getDesc() {
        return "\n Your book's cover is SOFT";
    }
}
