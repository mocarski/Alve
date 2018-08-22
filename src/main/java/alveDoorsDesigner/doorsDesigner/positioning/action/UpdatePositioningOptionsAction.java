package alveDoorsDesigner.doorsDesigner.positioning.action;

import alveDoorsDesigner.doorsDesigner.positioning.PositioningOptionsView;
import com.vaadin.data.HasValue;

public class UpdatePositioningOptionsAction implements HasValue.ValueChangeListener<String>{

    private final PositioningOptionsView positioningOptionsView;

    public UpdatePositioningOptionsAction(PositioningOptionsView positioningOptionsView) {
        this.positioningOptionsView = positioningOptionsView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        positioningOptionsView.updateAvailablePositioningOptions();
    }
}
