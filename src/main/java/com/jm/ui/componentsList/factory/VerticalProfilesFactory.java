package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.model.WardrobeToolbox;
import com.jm.model.enums.DoorFrameColour;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class VerticalProfilesFactory implements ListItemsFactory {
    @Override
    public List<ListItem> create(Wardrobe wardrobe) {

        List<ListItem> items = new ArrayList<>();

        items.add( new ListItem(
                Constants.getItemCodeForVerticalProfileLeft(wardrobe.getDoorFrameColour()),
                Constants.VERTICAL_PROFILE_LEFT + WardrobeToolbox.getColor(wardrobe),
                Integer.toString(wardrobe.getDoorsHeight()),
                wardrobe.getAmountOfDoors()));

        items.add(new ListItem(
                Constants.getItemCodeForVerticalProfileRight(wardrobe.getDoorFrameColour()),
                Constants.VERTICAL_PROFILE_RIGHT + WardrobeToolbox.getColor(wardrobe),
                Integer.toString(wardrobe.getDoorsHeight()),
                wardrobe.getAmountOfDoors()));

        return items;
    }
}
