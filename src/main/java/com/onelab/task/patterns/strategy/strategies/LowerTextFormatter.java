package com.onelab.task.patterns.strategy.strategies;

import com.onelab.task.patterns.strategy.TextFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowerTextFormatter implements TextFormatter {

    private static final Logger logger = LoggerFactory.getLogger(LowerTextFormatter.class);

    @Override
    public void format(String text) {
        logger.info("[LowerTextFormatter]: "+text.toLowerCase());
    }
}
