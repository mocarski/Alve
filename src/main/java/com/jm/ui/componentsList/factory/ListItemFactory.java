package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.componentsList.model.ListItem;

public interface ListItemFactory {
    ListItem create(Wardrobe wardrobe);
}
