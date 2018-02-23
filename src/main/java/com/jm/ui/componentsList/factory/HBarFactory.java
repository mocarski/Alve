package com.jm.ui.componentsList.factory;

import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.model.WardrobeToolbox;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class HBarFactory implements ListItemFactory {
    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                Constants.getItemCodeForHBar(wardrobe.getDoorFrameColour()),
                Constants.H_BAR + WardrobeToolbox.getColor(wardrobe),
                Integer.toString(getWidthOfHBars(wardrobe)),
                countNumberOfHBars(wardrobe));
    }

    private int getWidthOfHBars(Wardrobe wardrobe) {
        return wardrobe.getDoors().get(0).getModules().get(0).getWidth();
    }

    private int countNumberOfHBars(Wardrobe wardrobe) {
        int numberOfHBars = 0;
        for (Door door : wardrobe.getDoors()) {
            numberOfHBars += door.getAmountOfDivisions();
        }

        return numberOfHBars;
    }
}
