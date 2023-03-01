package com.exercise.pinapp.dominio.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LifeExpectancy {

    ARGENTINA("Argentina", 79);

    private String country;
    private Integer lifeExpectancy;
}