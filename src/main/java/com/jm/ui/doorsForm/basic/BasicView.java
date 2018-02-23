package com.jm.ui.doorsForm.basic;

import com.jm.model.enums.DoorFrameColour;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.action.UpdateVisibilityOfPreviewButton;
import com.jm.ui.doorsForm.additionalassortments.action.UpdateAdditionalAssortmentsVisibility;
import com.jm.ui.doorsForm.additionalassortments.action.UpdateColors;
import com.jm.ui.doorsForm.divisions.action.UpdateDivisionsViewVisibility;
import com.jm.ui.doorsForm.fulfillments.action.UpdateFulfillmentsVisibility;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualizationVisibility;
import com.vaadin.data.Binder;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;


public class BasicView extends FormLayout
{
    private TextField referenceName;
    private NativeSelect<String> doorFrameColour;

    public BasicView( Wardrobe wardrobe )
    {
        referenceName = createReferenceNameTextField();
        doorFrameColour = createDoorFrameColourSelect();

        createReferenceNameBinder( referenceName ).setBean( wardrobe );
        createColourBinder( doorFrameColour ).setBean( wardrobe );

        addComponents( referenceName, doorFrameColour);

        // Take minimum space
        setSizeUndefined();
        setStyleName("MarginTop");
    }

    public void setActions(UpdateVisualizationVisibility updateVisualizationVisibility,
                           UpdateDivisionsViewVisibility updateDivisionsViewVisibility,
                           UpdateFulfillmentsVisibility updateFulfillmentsVisibility,
                           UpdateAdditionalAssortmentsVisibility updateAdditionalAssortmentsVisibility,
                           UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton, UpdateColors updateColors)
    {
        referenceName.addValueChangeListener(updateVisualizationVisibility);
        referenceName.addValueChangeListener(updateDivisionsViewVisibility);
        referenceName.addValueChangeListener(updateFulfillmentsVisibility);
        referenceName.addValueChangeListener(updateAdditionalAssortmentsVisibility);
        referenceName.addValueChangeListener(updateVisibilityOfPreviewButton);

        doorFrameColour.addValueChangeListener(updateColors);
    }


    public boolean isReferenceNameValid() {
        return referenceName.getValue().equals("") ? false : true;
    }


    private TextField createReferenceNameTextField()
    {
        TextField referenceNameTextField = new TextField();
        referenceNameTextField.setPlaceholder(Constants.REFERENCE_NAME);
        referenceNameTextField.setCaption( Constants.REFERENCE_NAME );
        referenceNameTextField.setWidth( "10%" );

        return referenceNameTextField;
    }


    private NativeSelect<String> createDoorFrameColourSelect()
    {
        NativeSelect<String> doorFrameColourSelect = new NativeSelect<>( Constants.DOOR_FRAME_COLOUR );

        doorFrameColourSelect.setItems( DoorFrameColour.getDoorFrameColours() );
        doorFrameColourSelect.setWidth( "10%" );

        doorFrameColourSelect.setEmptySelectionAllowed( false );

        return doorFrameColourSelect;
    }

    private Binder<Wardrobe> createReferenceNameBinder(TextField textField )
    {
        Binder<Wardrobe> binder = new Binder<>();

        binder.forField( textField )
                .asRequired(Constants.REFERENCE_NAME_IS_REQUIRED)
                .bind( Wardrobe::getReferenceName, Wardrobe::setReferenceName );

        return binder;
    }

    private Binder<Wardrobe> createColourBinder(NativeSelect<String> typeSelect )
    {
        Binder<Wardrobe> binder = new Binder<>();

        binder.forField( typeSelect )
                .bind( Wardrobe::getDoorFrameColour, Wardrobe::setDoorFrameColour );

        return binder;
    }
}
