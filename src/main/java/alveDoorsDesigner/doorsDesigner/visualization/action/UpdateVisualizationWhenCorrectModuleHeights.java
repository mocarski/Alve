package alveDoorsDesigner.doorsDesigner.visualization.action;

import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.FulfillmentHeightView;
import alveDoorsDesigner.doorsDesigner.visualization.VisualizationView;
import com.vaadin.data.HasValue;

public class UpdateVisualizationWhenCorrectModuleHeights implements HasValue.ValueChangeListener<String> {
    private final VisualizationView visualizationView;
    private final FulfillmentHeightView fulfillmentHeightView;


    public UpdateVisualizationWhenCorrectModuleHeights(VisualizationView visualizationView,
                                                       FulfillmentHeightView fulfillmentHeightView) {
        this.visualizationView = visualizationView;
        this.fulfillmentHeightView = fulfillmentHeightView;
    }


    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        if (fulfillmentHeightView.isValid()) {
            visualizationView.update();
        }
    }
}
