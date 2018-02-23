package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class TopWheeledConnectorsFactory implements ListItemsFactory {
    @Override
    public List<ListItem> create(Wardrobe wardrobe) {

        List<ListItem> items = new ArrayList<>();

        items.add(new ListItem(
                Constants.TOP_WHEELED_CONNECTOR_LEFT_ITEM_CODE,
                Constants.TOP_WHEELED_CONNECTOR_LEFT,
                "",
                wardrobe.getDoors().size()));
        items.add(new ListItem(
                Constants.TOP_WHEELED_CONNECTOR_RIGHT_ITEM_CODE,
                Constants.TOP_WHEELED_CONNECTOR_RIGHT,
                "",
                wardrobe.getDoors().size()));

        return items;
    }
}
