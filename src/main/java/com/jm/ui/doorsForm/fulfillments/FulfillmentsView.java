package com.jm.ui.doorsForm.fulfillments;

import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.fulfillments.fulfillment.FulfillmentView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class FulfillmentsView extends VerticalLayout
{
    private final Wardrobe wardrobe;

    public FulfillmentsView( Wardrobe wardrobe)
    {
        this.wardrobe = wardrobe;

        setWidthUndefined();
        setStyleName("MarginTop");

        createFulfillments();
        hideFulfillments();
    }

    public void createFulfillments()
    {
        removeAllComponents();

        Label label = new Label(Constants.TYPE_OF_FILLINGS);

        addComponent(label);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        for( Door door : wardrobe.getDoors())
        {
            FulfillmentView fulfillmentView = new FulfillmentView(door);

            horizontalLayout.addComponent( fulfillmentView );
        }

        horizontalLayout.setWidthUndefined();

        addComponent(horizontalLayout);
    }

    public void hideFulfillments() {
        setVisible( false );
    }

    public void showFulfillments() {
        setVisible( true );
    }
}
