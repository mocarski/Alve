package com.jm.ui.doorsForm.divisions;

import com.google.common.base.Strings;
import com.jm.model.Door;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.action.UpdateVisibilityOfPreviewButton;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsView;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsViewVisibility;
import com.jm.ui.doorsForm.fulfillments.action.CreateFulfillments;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualization;
import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.ui.TextField;

public class DoorDivisionsTextField extends TextField {

    private final CreateFulfillments createFulfillments;
    private final UpdateVisualization updateVisualization;
    private final UpdateHeightOfFillingsView updateHeightOfFillingsView;
    private final UpdateHeightOfFillingsViewVisibility updateHeightOfFillingsViewVisibility;
    private final UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton;
    Binder<Door> binder = new Binder<>();

    private Door door;

    public DoorDivisionsTextField(Door door, UpdateHeightOfFillingsView
            updateHeightOfFillingsView, CreateFulfillments
                                          createFulfillments, UpdateVisualization updateVisualization,
                                  UpdateHeightOfFillingsViewVisibility updateHeightOfFillingsViewVisibility,
                                  UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton) {
        this.createFulfillments = createFulfillments;
        this.updateVisualization = updateVisualization;
        this.updateHeightOfFillingsView = updateHeightOfFillingsView;
        this.updateHeightOfFillingsViewVisibility = updateHeightOfFillingsViewVisibility;
        this.updateVisibilityOfPreviewButton = updateVisibilityOfPreviewButton;
        this.door = door;

        setPlaceholder(Constants.DIVIDERS_AMOUNT);

        // The only way to achieve proper UI behaviour when TextField is binded with int variable and
        // placeholder at the beginning should be shown.
        addValueChangeListener(getNumberOfDividersValueChangeListener(door));
    }

    private HasValue.ValueChangeListener<String> getNumberOfDividersValueChangeListener(Door door) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                        isBinded = true;
                    createAmountOfModulesBinder().setBean(door);
                    addValueChangeListener(updateHeightOfFillingsView);
                    addValueChangeListener(createFulfillments);
                    addValueChangeListener(updateVisualization);
                    addValueChangeListener(updateHeightOfFillingsViewVisibility);
                    addValueChangeListener(updateVisibilityOfPreviewButton);
                    setValue(valueChangeEvent.getValue().toString());
                }
            }
        };
    }

    private Binder<Door> createAmountOfModulesBinder() {
        binder.forField(this)
                .asRequired("DivisionsView amount is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(amountOfModules -> amountOfModules <= 5,
                        "Number of divisions can not be higher than 5")
                .bind(Door::getAmountOfDivisions, Door::setAmountOfDivision);

        return binder;
    }

    public boolean isValid(){
        return binder.isValid() && !Strings.isNullOrEmpty(getValue());
    }
}
