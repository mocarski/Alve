package com.jm.ui.doorsForm.additionalassortment;


import com.jm.model.*;
import com.jm.model.enums.PositioningOption;
import com.vaadin.data.Binder;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;

import java.util.Arrays;

public class AdditionalAssortmentView extends VerticalLayout{

    private NativeSelect<PositioningOption> positioningOption = new NativeSelect<>( );


    public void updatePositioningOptionState(Wardrobe wardrobe, Door door)
    {
        removeAllComponents();
        positioningOption = new NativeSelect<>();


        if( WardrobeToolbox.isUtmostSection( wardrobe, door) && door.getWidth() >= 600 ) {
            positioningOption.setItems( PositioningOption.values() );
        }
        else {
            positioningOption.setItems(Arrays.asList( PositioningOption.Positioners ) );
        }

        createPositioningOptionBinder(positioningOption).setBean(door);

        addComponents(positioningOption);
    }


    private Binder<Door> createPositioningOptionBinder(NativeSelect<PositioningOption> typeSelect )
    {
        Binder<Door> binder = new Binder<>();

        binder.forField( typeSelect )
                .bind( Door::getPositioningOption, Door::setPositioningOption);

        return binder;
    }
}
