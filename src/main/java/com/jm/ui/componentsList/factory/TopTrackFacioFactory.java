package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class TopTrackFacioFactory implements ListItemFactory{

    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                Constants.getItemCodeForTopTrackFacio(wardrobe.getTopTrackFacio()),
                Constants.TOP_TRACK_FACIO + getColourInBraces(wardrobe),
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }

    private String getColourInBraces(Wardrobe wardrobe) {
        return " (" + wardrobe.getTopTrackFacio() + ")";
    }
}
