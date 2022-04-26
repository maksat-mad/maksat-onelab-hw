package com.onelab.task.patterns.adapter.impl;

import com.onelab.task.entities.UserRequestTime;
import com.onelab.task.patterns.adapter.newformat.NewUserRequestTime;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Data
public class NewTimeFormatAdapter implements NewUserRequestTime {

    private String time;

    public NewTimeFormatAdapter(UserRequestTime userRequestTime) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String time = "This is new adapted time: "
                + dateFormat.format(userRequestTime.getTime()) + " :)";
        this.time = time;
    }

    @Override
    public String getTime() {
        return time;
    }
}
