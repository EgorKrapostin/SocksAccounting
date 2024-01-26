package com.example.socksaccounting.model;

import lombok.Getter;

@Getter
public enum Operations {

    equal("="),
    moreThan(">"),
    lessThan("<");


    private String operation;

    Operations(String operation) {
        this.operation = operation;
    }
}
