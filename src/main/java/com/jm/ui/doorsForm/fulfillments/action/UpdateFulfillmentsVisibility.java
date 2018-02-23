package com.jm.ui.doorsForm.fulfillments.action;


import com.jm.ui.doorsForm.basic.BasicView;
import com.jm.ui.doorsForm.cavitydimention.CavityDimentionsView;
import com.jm.ui.doorsForm.fulfillments.FulfillmentsView;
import com.vaadin.data.HasValue;

public class UpdateFulfillmentsVisibility implements HasValue.ValueChangeListener<String> {

    private final CavityDimentionsView cavityDimentionsView;
    private final FulfillmentsView fulfillmentsView;
    private final BasicView basicView;

    public UpdateFulfillmentsVisibility(CavityDimentionsView cavityDimentionsView,
                                        FulfillmentsView fulfillmentsView,
                                        BasicView basicView)
    {
        this.cavityDimentionsView = cavityDimentionsView;
        this.fulfillmentsView = fulfillmentsView;
        this.basicView = basicView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        if (cavityDimentionsView.isCavityDimentionsValid() &&
                basicView.isReferenceNameValid()) {
            fulfillmentsView.showFulfillments();
        } else {
            fulfillmentsView.hideFulfillments();
        }
    }
}
