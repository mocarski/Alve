package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class SiliconBufferingDrops implements ListItemFactory {
    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                "OC127",
                Constants.SILICON_BUFFERING_DROPS,
                "",
                wardrobe.getDoors().size() * 10);
    }
}
