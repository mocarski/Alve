package com.jm.ui.componentsList.factory;

import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class SelftappingWoodScrewFactory implements ListItemsFactory {
    @Override
    public List<ListItem> create(Wardrobe wardrobe) {

        List<ListItem> items = new ArrayList<>();

        items.add(new ListItem(
                "WM316",
                Constants.SELFTAPPING_WOOD_SCREW,
                Constants._3MM_16MM,
                calculateAmountOfSelftapping(wardrobe)));
        items.add(new ListItem(
                "WM325",
                Constants.SELFTAPPING_WOOD_SCREW,
                Constants._3MM_25MM,
                calculateAmountOfSelftapping(wardrobe)));

        return items;
    }

    private int calculateAmountOfSelftapping(Wardrobe wardrobe) {
        int result = 0;

        for (Door door : wardrobe.getDoors()) {
            result = result + 8 + door.getAmountOfDivisions() * 2;
        }

        return result;
    }

}
