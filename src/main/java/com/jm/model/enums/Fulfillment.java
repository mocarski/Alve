package com.jm.model.enums;


public enum Fulfillment {
    GLASS("4mm(Glass)"),
    BOARD("8mm(Board)");

    String type;

    Fulfillment(String type) {
        this.type = type;
    }
}
