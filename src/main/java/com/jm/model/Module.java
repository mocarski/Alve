package com.jm.model;

import com.jm.model.enums.Fulfillment;

/*Represents place where glass or board is set*/
public class Module {
    private int width;
    private int height;
    private Fulfillment fulfillment = Fulfillment.GLASS;

    public Module(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getWidth() {
        return width;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public int getHeight() {
        return height;
    }

    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    public Fulfillment getFulfillment()
    {
        return fulfillment;
    }
}

