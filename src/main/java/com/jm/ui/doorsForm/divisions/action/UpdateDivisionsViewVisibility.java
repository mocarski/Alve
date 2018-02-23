package com.jm.ui.doorsForm.divisions.action;

import com.jm.ui.doorsForm.basic.BasicView;
import com.jm.ui.doorsForm.cavitydimention.CavityDimentionsView;
import com.jm.ui.doorsForm.divisions.DivisionsView;
import com.vaadin.data.HasValue;

public class UpdateDivisionsViewVisibility implements HasValue.ValueChangeListener<String> {

    private final CavityDimentionsView cavityDimentionsView;
    private final DivisionsView divisionsView;
    private final BasicView basicView;

    public UpdateDivisionsViewVisibility(CavityDimentionsView cavityDimentionsView,
                                         DivisionsView divisionsView,
                                         BasicView basicView)
    {
        this.cavityDimentionsView = cavityDimentionsView;
        this.divisionsView = divisionsView;
        this.basicView = basicView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        if (cavityDimentionsView.isCavityDimentionsValid() &&
                basicView.isReferenceNameValid()) {
            divisionsView.show();
        } else {
            divisionsView.hide();
        }
    }
}
