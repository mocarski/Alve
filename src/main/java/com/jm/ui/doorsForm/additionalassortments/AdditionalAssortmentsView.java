package com.jm.ui.doorsForm.additionalassortments;


import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.additionalassortment.AdditionalAssortmentController;
import com.jm.ui.doorsForm.additionalassortment.AdditionalAssortmentView;
import com.vaadin.data.Binder;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdditionalAssortmentsView extends VerticalLayout {

    private final Wardrobe wardrobe;
    NativeSelect<String> topTrackFacio = new NativeSelect<>(Constants.TOP_TRACK_FACIO);
    NativeSelect<String> bottomTrackCover = new NativeSelect<>(Constants.BOTTOM_TRUCK_COVER);
    private List<AdditionalAssortmentController> controllers = new ArrayList<>();

    public AdditionalAssortmentsView(Wardrobe wardrobe)
    {
        this.wardrobe = wardrobe;
        setWidthUndefined();

        createTopTruckCoverBinder(topTrackFacio).setBean(wardrobe);
        createBottomTruckCoverBinder(bottomTrackCover).setBean(wardrobe);

        prepareView();
        hideAdditionalAssortments();
    }

    public void updatePositioningOptionsState()
    {
        for( AdditionalAssortmentController additionalAssortmentController : getAdditionalAssortmentControllers() )
        {
            additionalAssortmentController.updatePositioningOptionState();
        }
    }

    public void hideAdditionalAssortments() {
        setVisible( false );
    }

    public void showAdditionalAssortments() {
        setVisible( true );
    }


    public void prepareView()
    {
        removeAllComponents();
        controllers.clear();

        HorizontalLayout positionerOptionsLayout = new HorizontalLayout();

        for (Door door : wardrobe.getDoors()) {
            AdditionalAssortmentView additionalAssortmentView = new AdditionalAssortmentView();
            AdditionalAssortmentController additionalAssortmentController = new AdditionalAssortmentController(additionalAssortmentView, wardrobe, door);
            controllers.add(additionalAssortmentController);

            positionerOptionsLayout.addComponent(additionalAssortmentView);
        }

        topTrackFacio.setItems(Arrays.asList( wardrobe.getDoorFrameColour(), Constants.WHITE ));
        bottomTrackCover.setItems(wardrobe.getDoorFrameColour(), Constants.SILVER);
        topTrackFacio.setWidth("10%");
        bottomTrackCover.setWidth("10%");
        topTrackFacio.setEmptySelectionAllowed( false );
        bottomTrackCover.setEmptySelectionAllowed( false );


        FormLayout formLayout = new FormLayout();
        formLayout.addComponents(topTrackFacio, bottomTrackCover);
        formLayout.setSizeUndefined();


        Label label = new Label(Constants.ACCESSORIES);
        addComponents(label, positionerOptionsLayout, formLayout);
        setComponentAlignment(label, Alignment.TOP_CENTER);
        setComponentAlignment(formLayout, Alignment.TOP_CENTER);
        setStyleName("MarginTop");
    }

    public void updateColors(){
        topTrackFacio.setItems(Arrays.asList( wardrobe.getDoorFrameColour(), Constants.WHITE ));
        bottomTrackCover.setItems(wardrobe.getDoorFrameColour(), Constants.SILVER);
    }

    public List<AdditionalAssortmentController> getAdditionalAssortmentControllers()
    {
        return controllers;
    }

    private Binder<Wardrobe> createTopTruckCoverBinder(NativeSelect<String> typeSelect )
    {
        Binder<Wardrobe> binder = new Binder<>();

        binder.forField( typeSelect )
                .bind( Wardrobe::getTopTrackFacio, Wardrobe::setTopTrackFacio);

        return binder;
    }

    private Binder<Wardrobe> createBottomTruckCoverBinder(NativeSelect<String> typeSelect )
    {
        Binder<Wardrobe> binder = new Binder<>();

        binder.forField( typeSelect )
                .bind( Wardrobe::getBottomTrackCover, Wardrobe::setBottomTruckCover );

        return binder;
    }


}
