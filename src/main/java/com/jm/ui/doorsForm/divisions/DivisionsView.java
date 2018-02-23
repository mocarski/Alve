package com.jm.ui.doorsForm.divisions;

import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.action.UpdateVisibilityOfPreviewButton;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsView;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsViewVisibility;
import com.jm.ui.doorsForm.fulfillments.action.CreateFulfillments;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualization;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class DivisionsView extends VerticalLayout {

    private final Wardrobe wardrobe;
    private Label label = new Label(Constants.NUMBER_OF_DIVISIONS);
    private HorizontalLayout layout = new HorizontalLayout();

    private List<DoorDivisionsTextField> doorDivisionsTextFieldList = new ArrayList<>();

    public DivisionsView(Wardrobe wardrobe)
    {
        this.wardrobe = wardrobe;
        setWidthUndefined();
        setStyleName("MarginTop");

        addComponents(label, layout);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        hide();
    }

    public void updateUI(){
        layout.removeAllComponents();
        doorDivisionsTextFieldList.clear();
        for(Door door : wardrobe.getDoors()) {
            DoorDivisionsTextField doorDivisionsTextField = new DoorDivisionsTextField(door, updateHeightOfFillingsView,
                    createFulfillments, updateVisualization, updateHeightOfFillingsViewVisibility,
                    updateVisibilityOfPreviewButton );
            doorDivisionsTextFieldList.add(doorDivisionsTextField);

            layout.addComponent(doorDivisionsTextField);
        }
    }

    public void show() {
        setVisible( true );
    }

    public void hide() { setVisible( false ); }

    public void setActions(UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton, CreateFulfillments createFulfillments,
                           UpdateHeightOfFillingsView updateHeightOfFillingsView,
                           UpdateVisualization updateVisualization,
                           UpdateHeightOfFillingsViewVisibility updateHeightOfFillingsViewVisibility) {
        this.updateVisibilityOfPreviewButton = updateVisibilityOfPreviewButton;
        this.createFulfillments = createFulfillments;
        this.updateHeightOfFillingsView = updateHeightOfFillingsView;
        this.updateVisualization = updateVisualization;
        this.updateHeightOfFillingsViewVisibility = updateHeightOfFillingsViewVisibility;
    }

    private UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton;
    private CreateFulfillments createFulfillments;
    private UpdateHeightOfFillingsView updateHeightOfFillingsView;
    private UpdateVisualization updateVisualization;
    private UpdateHeightOfFillingsViewVisibility updateHeightOfFillingsViewVisibility;

    public boolean isValid(){
        for(DoorDivisionsTextField doorDivisionsTextField : doorDivisionsTextFieldList){
            if(!doorDivisionsTextField.isValid())
                return false;
        }

        return true;
    }
}
