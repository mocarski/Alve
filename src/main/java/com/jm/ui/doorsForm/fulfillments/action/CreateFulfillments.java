package com.jm.ui.doorsForm.fulfillments.action;


import com.jm.ui.doorsForm.fulfillments.FulfillmentsView;
import com.vaadin.data.HasValue;

public class CreateFulfillments implements HasValue.ValueChangeListener<String>
{
    private final FulfillmentsView fulfillmentsView;

    public CreateFulfillments(FulfillmentsView fulfillmentsView)
    {
        this.fulfillmentsView = fulfillmentsView;
    }


    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent)
    {
        fulfillmentsView.createFulfillments();
    }
}
