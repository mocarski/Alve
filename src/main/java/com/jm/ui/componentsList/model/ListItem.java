package com.jm.ui.componentsList.model;


public class ListItem {

    private final String itemCode;
    private final String name;
    private final String dimention;
    private final int quantity;

    public ListItem(String itemCode, String name, String dimention, int quantity)
    {
        this.itemCode = itemCode;
        this.name = name;
        this.dimention = dimention;
        this.quantity = quantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }

    public String getDimention() {
        return dimention;
    }

    public int getQuantity() {
        return quantity;
    }

}
