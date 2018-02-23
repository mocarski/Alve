package com.jm.ui.doorsForm.fulfillmentHeight.action;

import com.jm.ui.doorsForm.fulfillmentHeight.HeightOfFillingsView;
import com.vaadin.data.HasValue;

public class UpdateHeightOfFillingsView implements HasValue.ValueChangeListener<String> {

    private final HeightOfFillingsView heightOfFillingsView;

    public UpdateHeightOfFillingsView(HeightOfFillingsView heightOfFillingsView){
        this.heightOfFillingsView = heightOfFillingsView;
    }
    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        heightOfFillingsView.updateUI();
    }
}
