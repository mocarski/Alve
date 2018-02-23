package com.jm.ui.doorsForm.fulfillmentHeight.action;

import com.jm.ui.doorsForm.fulfillmentHeight.HeightOfFillingsView;
import com.vaadin.data.HasValue;

public class UpdateValidityOfFillingHeights implements HasValue.ValueChangeListener<String>{

    private final HeightOfFillingsView heightOfFillingsView;

    public UpdateValidityOfFillingHeights(HeightOfFillingsView heightOfFillingsView){
        this.heightOfFillingsView = heightOfFillingsView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        heightOfFillingsView.validate();
    }
}
