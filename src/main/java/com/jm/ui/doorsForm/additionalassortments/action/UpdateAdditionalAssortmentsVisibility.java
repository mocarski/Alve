package com.jm.ui.doorsForm.additionalassortments.action;


import com.jm.ui.doorsForm.additionalassortments.AdditionalAssortmentsView;
import com.jm.ui.doorsForm.basic.BasicView;
import com.jm.ui.doorsForm.cavitydimention.CavityDimentionsView;
import com.vaadin.data.HasValue;

public class UpdateAdditionalAssortmentsVisibility implements HasValue.ValueChangeListener<String> {

    private final CavityDimentionsView cavityDimentionsView;
    private final AdditionalAssortmentsView additionalAssortmentsView;
    private final BasicView basicView;

    public UpdateAdditionalAssortmentsVisibility(
            CavityDimentionsView cavityDimentionsView,
            AdditionalAssortmentsView additionalAssortmentsView,
            BasicView basicView)
    {
        this.cavityDimentionsView = cavityDimentionsView;
        this.additionalAssortmentsView = additionalAssortmentsView;
        this.basicView = basicView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        if (cavityDimentionsView.isCavityDimentionsValid() &&
                basicView.isReferenceNameValid()) {
            additionalAssortmentsView.showAdditionalAssortments();
        } else {
            additionalAssortmentsView.hideAdditionalAssortments();
        }
    }
}