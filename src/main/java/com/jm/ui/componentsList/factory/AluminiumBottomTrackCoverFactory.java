package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class AluminiumBottomTrackCoverFactory implements ListItemFactory{
    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                "ZT00...",
                Constants.ALUMINIUM_TRACK_COVER + " (Silver)",
                Integer.toString(wardrobe.getCavityWidth()),
                1);

    }
}
