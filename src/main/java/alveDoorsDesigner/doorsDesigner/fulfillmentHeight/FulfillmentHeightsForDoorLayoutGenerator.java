package alveDoorsDesigner.doorsDesigner.fulfillmentHeight;

import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateValidityOfFulfillmentHeightsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualizationWhenCorrectModuleHeights;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import com.vaadin.ui.VerticalLayout;

public class FulfillmentHeightsForDoorLayoutGenerator {

    public FulfillmentHeightsForDoorLayoutGenerator(
            UpdateVisualizationWhenCorrectModuleHeights updateVisualizationWhenCorrectModuleHeights,
            UpdateVisibility updateVisibility, UpdateValidityOfFulfillmentHeightsAction
                    updateValidityOfFulfillmentHeightsAction) {
        this.updateVisualizationWhenCorrectModuleHeights = updateVisualizationWhenCorrectModuleHeights;
        this.updateVisibility = updateVisibility;
        this.updateValidityOfFulfillmentHeightsAction = updateValidityOfFulfillmentHeightsAction;
    }

    public VerticalLayout generate(Door door) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMargin(false);

        for (Module module : door.getModules()) {
            FulfillmentHeightTextField fulfillmentHeightTextField = createFulfillmentHeightTextField(door,
                    module);
            verticalLayout.addComponent(fulfillmentHeightTextField);
        }

        return verticalLayout;
    }

    private FulfillmentHeightTextField createFulfillmentHeightTextField(Door door, Module module) {
        FulfillmentHeightTextField fulfillmentHeightTextField = new FulfillmentHeightTextField(door,
                module);
        fulfillmentHeightTextField.addValueChangeListener(updateVisibility);
        fulfillmentHeightTextField.addValueChangeListener(updateVisualizationWhenCorrectModuleHeights);
        fulfillmentHeightTextField.addValueChangeListener(updateValidityOfFulfillmentHeightsAction);
        return fulfillmentHeightTextField;
    }

    private final UpdateVisualizationWhenCorrectModuleHeights updateVisualizationWhenCorrectModuleHeights;
    private final UpdateVisibility updateVisibility;
    private final UpdateValidityOfFulfillmentHeightsAction updateValidityOfFulfillmentHeightsAction;
}
