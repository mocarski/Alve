package com.jm.ui.doorsForm;

import com.jm.ui.doorsForm.additionalassortments.AdditionalAssortmentsView;
import com.jm.ui.doorsForm.basic.BasicView;
import com.jm.ui.doorsForm.cavitydimention.CavityDimentionsView;
import com.jm.ui.doorsForm.divisions.DivisionsView;
import com.jm.ui.doorsForm.fulfillmentHeight.HeightOfFillingsView;
import com.jm.ui.doorsForm.fulfillments.FulfillmentsView;
import com.jm.ui.doorsForm.visualization.VisualizationView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


public class WardrobeFormView
        extends VerticalLayout implements View{
    private final VisualizationView wardrobeVisualization;
    private final BasicView basicView;
    private final CavityDimentionsView cavityDimentionsView;
    private final DivisionsView divisionsView;
    private final HeightOfFillingsView heightOfFillingsView;
    private final FulfillmentsView fulfillmentsView;
    private final AdditionalAssortmentsView additionalAssortmentsView;
    private final Button button;

    public WardrobeFormView(VisualizationView visualizationView, BasicView basicView, CavityDimentionsView cavityDimentionsView,
                            DivisionsView divisionsView, HeightOfFillingsView heightOfFillingsView,
                            FulfillmentsView fulfillmentsView, AdditionalAssortmentsView additionalAssortmentsView, Button button) {
        this.wardrobeVisualization = visualizationView;
        this.basicView = basicView;
        this.cavityDimentionsView = cavityDimentionsView;
        this.divisionsView = divisionsView;
        this.heightOfFillingsView = heightOfFillingsView;
        this.fulfillmentsView = fulfillmentsView;
        this.additionalAssortmentsView = additionalAssortmentsView;
        this.button = button;


        addComponents(visualizationView, basicView, cavityDimentionsView, divisionsView,
                heightOfFillingsView, fulfillmentsView, additionalAssortmentsView, button);
        setComponentAlignment(visualizationView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(basicView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(cavityDimentionsView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(divisionsView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(heightOfFillingsView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(fulfillmentsView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(additionalAssortmentsView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        setStyleName("MarginTop");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {}
}
