package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.componentsList.model.ListItem;

import java.util.List;

public interface ListItemsFactory {
    List<ListItem> create(Wardrobe wardrobe);
}
