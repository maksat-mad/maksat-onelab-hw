package com.onelab.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preference {
    private String music;
    private String meal;
    private String movie;
    private String sport;
}
