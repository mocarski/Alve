package com.jm.ui.doorsForm.additionalassortments.action;

import com.jm.ui.doorsForm.additionalassortments.AdditionalAssortmentsView;
import com.vaadin.data.HasValue;

public class UpdateColors implements HasValue.ValueChangeListener<String> {

    private final AdditionalAssortmentsView additionalAssortmentsView;

    public UpdateColors(AdditionalAssortmentsView additionalAssortmentsView){
        this.additionalAssortmentsView = additionalAssortmentsView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        additionalAssortmentsView.updateColors();
    }
}
