package com.jm.ui.doorsForm.fulfillmentHeight;

import com.jm.model.Door;
import com.jm.model.Module;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.action.UpdateVisibilityOfPreviewButton;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateValidityOfFillingHeights;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualizationWhenCorrectModuleHeights;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class HeightOfFillingsView extends VerticalLayout {

    private final Wardrobe wardrobe;
    private Label label = new Label(Constants.HEIGHT_OF_FILLINGS);
    private HorizontalLayout layoutForAllDoors = new HorizontalLayout();
    private List<VerticalLayout> layoutsForSingleDoor = new ArrayList<>();
    private List<HeightOfFillingTextField> fulfillmentsHeights = new ArrayList<>();


    public HeightOfFillingsView(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
        setWidthUndefined();
        setStyleName("MarginTop");

        addComponents(label, layoutForAllDoors);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        hide();
    }

    public void updateUI(){
        removeOldComponents();
        for(Door door : wardrobe.getDoors()){
            VerticalLayout fulfillmentHeightsForSingleDoor = new VerticalLayout();
            for(Module module : door.getModules()) {
                HeightOfFillingTextField heightOfFillingTextField = new HeightOfFillingTextField(door, module);
                heightOfFillingTextField.addValueChangeListener(updateVisibilityOfPreviewButton);
                heightOfFillingTextField.addValueChangeListener(updateVisualizationWhenCorrectModuleHeights);
                heightOfFillingTextField.addValueChangeListener(updateValidityOfFillingHeights);
                fulfillmentsHeights.add(heightOfFillingTextField);
                fulfillmentHeightsForSingleDoor.addComponent(heightOfFillingTextField);
            }
            layoutForAllDoors.addComponent(fulfillmentHeightsForSingleDoor);
        }
    }

    private void removeOldComponents() {
        layoutForAllDoors.removeAllComponents();
        for(VerticalLayout layoutForSingleDoor : layoutsForSingleDoor){
            layoutForSingleDoor.removeAllComponents();
        }
        fulfillmentsHeights.clear();
    }

    public void show() {setVisible( true ); }

    public void hide() {setVisible( false ); }

    public void setActions(UpdateVisualizationWhenCorrectModuleHeights
                                   updateVisualizationWhenCorrectModuleHeights,
                           UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton,
                           UpdateValidityOfFillingHeights updateValidityOfFillingHeights){
        this.updateVisualizationWhenCorrectModuleHeights = updateVisualizationWhenCorrectModuleHeights;
        this.updateVisibilityOfPreviewButton = updateVisibilityOfPreviewButton;
        this.updateValidityOfFillingHeights = updateValidityOfFillingHeights;
    }

    public boolean isValid() {
        for(HeightOfFillingTextField heightOfFillingTextField : fulfillmentsHeights){
            if(!heightOfFillingTextField.isValid())
                return false;
        }

        return true;
    }

    public void validate() {
        for(HeightOfFillingTextField heightOfFillingTextField : fulfillmentsHeights){
            heightOfFillingTextField.validate();
        }
    }

    private UpdateVisualizationWhenCorrectModuleHeights updateVisualizationWhenCorrectModuleHeights;
    private UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton;
    private UpdateValidityOfFillingHeights updateValidityOfFillingHeights;
}
