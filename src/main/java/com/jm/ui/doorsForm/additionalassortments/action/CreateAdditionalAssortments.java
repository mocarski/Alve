package com.jm.ui.doorsForm.additionalassortments.action;


import com.jm.ui.doorsForm.additionalassortments.AdditionalAssortmentsView;
import com.vaadin.data.HasValue;

public class CreateAdditionalAssortments implements HasValue.ValueChangeListener<String>{

    private final AdditionalAssortmentsView additionalAssortmentsView;

    public CreateAdditionalAssortments(AdditionalAssortmentsView additionalAssortmentsView)
    {
        this.additionalAssortmentsView = additionalAssortmentsView;
    }


    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent)
    {
        additionalAssortmentsView.prepareView();
    }
}
