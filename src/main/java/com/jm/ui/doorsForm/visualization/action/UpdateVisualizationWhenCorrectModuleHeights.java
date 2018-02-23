package com.jm.ui.doorsForm.visualization.action;

import com.jm.ui.doorsForm.fulfillmentHeight.HeightOfFillingsView;
import com.jm.ui.doorsForm.visualization.VisualizationView;
import com.vaadin.data.HasValue;

public class UpdateVisualizationWhenCorrectModuleHeights implements HasValue.ValueChangeListener<String> {
    private final VisualizationView visualizationView;
    private final HeightOfFillingsView heightOfFillingsView;


    public UpdateVisualizationWhenCorrectModuleHeights(VisualizationView visualizationView,
                                                       HeightOfFillingsView heightOfFillingsView)
    {
        this.visualizationView = visualizationView;
        this.heightOfFillingsView = heightOfFillingsView;
    }


    @Override
    public void valueChange( HasValue.ValueChangeEvent<String> valueChangeEvent )
    {
        if(heightOfFillingsView.isValid()){
            visualizationView.updateView();
        }
    }
}
