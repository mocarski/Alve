package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class SteelDoubleTopTrackFactory implements ListItemFactory {

    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                "TG005",
                Constants.STEEL_DOUBLE_TOP_TRACK,
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }
}
