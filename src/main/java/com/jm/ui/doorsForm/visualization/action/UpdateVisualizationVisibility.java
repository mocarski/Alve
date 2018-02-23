package com.jm.ui.doorsForm.visualization.action;

import com.jm.ui.doorsForm.basic.BasicView;
import com.jm.ui.doorsForm.cavitydimention.CavityDimentionsView;
import com.jm.ui.doorsForm.visualization.VisualizationView;
import com.vaadin.data.HasValue;

public class UpdateVisualizationVisibility implements HasValue.ValueChangeListener<String> {

    private final CavityDimentionsView cavityDimentionsView;
    private final VisualizationView visualizationView;
    private final BasicView basicView;

    public UpdateVisualizationVisibility(CavityDimentionsView cavityDimentionsView,
                                         VisualizationView visualizationView,
                                         BasicView basicView) {
        this.cavityDimentionsView = cavityDimentionsView;
        this.visualizationView = visualizationView;
        this.basicView = basicView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        if (cavityDimentionsView.isCavityDimentionsValid() &&
                basicView.isReferenceNameValid()) {
            visualizationView.showVisualization();
        } else {
            visualizationView.hideVisualization();
        }
    }
}
