package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class AluminiumDoubleBottomTrackFactory implements ListItemFactory {
    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                "TD00...",
                Constants.ALUMINIUM_DOUBLE_BOTTOM_TRACK + " (Silver)",
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }
}
