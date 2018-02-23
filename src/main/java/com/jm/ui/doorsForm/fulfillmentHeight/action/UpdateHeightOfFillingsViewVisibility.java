package com.jm.ui.doorsForm.fulfillmentHeight.action;

import com.jm.ui.doorsForm.divisions.DivisionsView;
import com.jm.ui.doorsForm.divisions.DoorDivisionsTextField;
import com.jm.ui.doorsForm.fulfillmentHeight.HeightOfFillingsView;
import com.vaadin.data.HasValue;

public class UpdateHeightOfFillingsViewVisibility implements HasValue.ValueChangeListener<String> {

    private final HeightOfFillingsView heightOfFillingsView;
    private DivisionsView divisionsView;

    public UpdateHeightOfFillingsViewVisibility(HeightOfFillingsView heightOfFillingsView, DivisionsView divisionsView){
        this.heightOfFillingsView = heightOfFillingsView;
        this.divisionsView = divisionsView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        if(divisionsView.isValid())
            heightOfFillingsView.show();
        else
            heightOfFillingsView.hide();
    }
}
