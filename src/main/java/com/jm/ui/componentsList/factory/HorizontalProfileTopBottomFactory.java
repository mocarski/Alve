package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.model.WardrobeToolbox;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class HorizontalProfileTopBottomFactory implements ListItemFactory {
    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                Constants.getItemCodeForHorizontalProfile(wardrobe.getDoorFrameColour()),
                Constants.HORIZONTAL_PROFILE_TOP_BOTTOM + WardrobeToolbox.getColor(wardrobe),
                Integer.toString(getWidthOfHorizontalProfile(wardrobe)),
                wardrobe.getAmountOfDoors() * 2);
    }

    private int getWidthOfHorizontalProfile(Wardrobe wardrobe) {
        return wardrobe.getDoors().get(0).getModules().get(0).getWidth();
    }
}
