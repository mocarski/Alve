package alveDoorsDesigner.doorsDesigner.visualization.action;

import alveDoorsDesigner.doorsDesigner.visualization.VisualizationView;
import com.vaadin.data.HasValue;


public class UpdateVisualization implements HasValue.ValueChangeListener<String> {
    private final VisualizationView visualizationView;

    public UpdateVisualization(VisualizationView visualizationView) {
        this.visualizationView = visualizationView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        visualizationView.update();
    }
}
