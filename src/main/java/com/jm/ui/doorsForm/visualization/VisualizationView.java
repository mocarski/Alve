package com.jm.ui.doorsForm.visualization;

import com.jm.model.Module;
import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.model.WardrobeToolbox;
import com.jm.ui.Constants;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;


public class VisualizationView extends HorizontalLayout {
    private final Wardrobe wardrobe;

    //Variable to change size of visualization by hand
    private int divider = 8;


    public VisualizationView(Wardrobe wardrobe){
        this.wardrobe = wardrobe;
        hideVisualization();
    }

    void update(Wardrobe wardrobe) {
        removeAllComponents();

        addComponent(createLayoutWithVisualization(wardrobe));
    }

    public void updateView()
    {
        update( wardrobe );
    }

    public void showVisualization() {
        setVisible(true);
    }

    public void hideVisualization() { setVisible(false); }

    private AbsoluteLayout createLayoutWithVisualization(Wardrobe wardrobe) {
        AbsoluteLayout visualization = new AbsoluteLayout();

        visualization.setWidth(wardrobe.getDoorsWidth() / divider + "px");
        visualization.setHeight(wardrobe.getDoorsHeight() / divider + "px");
        visualization.setStyleName("FrameColor");


        for (Door door : wardrobe.getDoors()) {
            createButtonsAsModulesForDoor(visualization, wardrobe, door);
        }

        return visualization;
    }


    private void createButtonsAsModulesForDoor(
            AbsoluteLayout visualization, Wardrobe wardrobe, Door door) {
        Button button = null;

        for (Module module : door.getModules()) {
            int width = Math.round(calculateWidthOfButton(wardrobe, door, module));
            int hight = Math.round(calculateHeightOfButton(door, module));

            button = createButton(width, hight);

            if (WardrobeToolbox.isSingleModule(wardrobe, door, module))
                button.setStyleName("Only");
            else if (WardrobeToolbox.isOnlyModuleInLeftSection(wardrobe, door, module))
                button.setStyleName("LeftOnly");
            else if (WardrobeToolbox.isOnlyModuleInRightSection(wardrobe, door, module))
                button.setStyleName("RightOnly");
            else if (WardrobeToolbox.isOnlyModuleInMiddleSection(wardrobe, door, module))
                button.setStyleName("MiddleOnly");
            else if (WardrobeToolbox.isTopModuleInLeftSection(wardrobe, door, module))
                button.setStyleName("LeftTop");
            else if (WardrobeToolbox.isBottomModuleInLeftSection(wardrobe, door, module))
                button.setStyleName("LeftBottom");
            else if (WardrobeToolbox.isTopModuleInRightSection(wardrobe, door, module))
                button.setStyleName("RightTop");
            else if (WardrobeToolbox.isBottomModuleInRightSection(wardrobe, door, module))
                button.setStyleName("RightBottom");
            else if (WardrobeToolbox.isMiddleModuleInLeftSection(wardrobe, door, module))
                button.setStyleName("MiddleLeft");
            else if (WardrobeToolbox.isMiddleModuleInRightSection(wardrobe, door, module))
                button.setStyleName("MiddleRight");
            else if (WardrobeToolbox.isTopModuleInMiddleSection(wardrobe, door, module))
                button.setStyleName("MiddleTop");
            else if (WardrobeToolbox.isBottomModuleInMiddleSection(wardrobe, door, module))
                button.setStyleName("MiddleBottom");
            else
                button.setStyleName("Middle");


            String cssPosition = String.format("top: %spx; left: %spx", WardrobeToolbox
                    .countSummaryHeightOfModulesOnTheTop(door, module) / divider, WardrobeToolbox
                    .countSummaryWidthOfSectionsOnTheLeft(wardrobe, door) / divider);

            visualization.addComponent(button, cssPosition);
        }
    }

    private int calculateHeightOfButton(Door door, Module module) {
        if (WardrobeToolbox.isSingleModule(door, module))
            return (module.getHeight() + 2*Constants.HORIZONTAL_PROFILE_WIDTH)/divider;
        else if (WardrobeToolbox.isUtmostModule(door, module))
            return (module.getHeight() + Constants.HORIZONTAL_PROFILE_WIDTH + Constants.HBAR_WIDTH/2)/divider;
        else
            return (module.getHeight() + Constants.HBAR_WIDTH)/divider;
    }

    private int calculateWidthOfButton(Wardrobe wardrobe, Door door, Module module) {

        if (WardrobeToolbox.isOnlySection(wardrobe,door))
            return door.getWidth()/divider;
        else if (WardrobeToolbox.isUtmostSection(wardrobe,door))
            return (int) ((door.getWidth() - 0.5*Constants.VERTICAL_PROFILE_WIDTH)/divider);
        else
            return (door.getWidth() - Constants.VERTICAL_PROFILE_WIDTH)/divider;
    }

    private Button createButton(float width, float height) {
        Button button = new NativeButton();
        button.setWidth(width + "px");
        button.setHeight(height + "px");
        return button;
    }
}
