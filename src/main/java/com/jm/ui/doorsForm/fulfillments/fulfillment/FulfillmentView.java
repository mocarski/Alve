package com.jm.ui.doorsForm.fulfillments.fulfillment;

import com.jm.model.Door;
import com.jm.model.Module;
import com.jm.model.enums.Fulfillment;
import com.vaadin.data.Binder;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class FulfillmentView extends VerticalLayout {
    private final Door door;

    public FulfillmentView(Door door)
    {
        this.door = door;

        createFulfillmentTextFields();
    }

    private void createFulfillmentTextFields()
    {
        for( Module module : door.getModules() )
        {
            HorizontalLayout fulfillmentDetails = new HorizontalLayout();

            List<Fulfillment> types = new ArrayList<>();
            types.add( Fulfillment.GLASS );
            types.add( Fulfillment.BOARD );

            NativeSelect<Fulfillment> typeSelect = new NativeSelect<>( );
            typeSelect.setItems( types );
            typeSelect.setEmptySelectionAllowed( false );

            createFulfillmentsBinder( typeSelect ).setBean( module );

            fulfillmentDetails.addComponents( typeSelect);

            addComponent(fulfillmentDetails);
        }
    }

    private Binder<Module> createFulfillmentsBinder(NativeSelect<Fulfillment> typeSelect )
    {
        Binder<Module> binder = new Binder<>();

        binder.forField( typeSelect )
                .bind( Module::getFulfillment, Module::setFulfillment );

        return binder;
    }
}
