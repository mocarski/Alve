package com.jm.ui.doorsForm.divisions.action;

import com.jm.ui.doorsForm.divisions.DivisionsView;
import com.vaadin.data.HasValue;

public class UpdateDivisionsView implements HasValue.ValueChangeListener<String>{

    private final DivisionsView divisionsView;

    public UpdateDivisionsView(DivisionsView divisionsView)
    {
        this.divisionsView = divisionsView;
    }


    @Override
    public void valueChange( HasValue.ValueChangeEvent<String> valueChangeEvent )
    {
        divisionsView.updateUI();
    }
}
