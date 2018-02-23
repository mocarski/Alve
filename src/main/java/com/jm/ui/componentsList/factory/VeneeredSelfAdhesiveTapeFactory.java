package com.jm.ui.componentsList.factory;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class VeneeredSelfAdhesiveTapeFactory implements ListItemFactory {
    @Override
    public ListItem create(Wardrobe wardrobe) {
            return new ListItem(
                    Constants.getItemCodeForVeeneredSelfAdhesiveTape(wardrobe.getDoorFrameColour()),
                    Constants.VENEERED_SELF_ADHESIVE_TAPE + getColourInBraces(wardrobe),
                    Integer.toString(wardrobe.getCavityWidth()),
                    1);
    }

    private String getColourInBraces(Wardrobe wardrobe) {
        return " (" + wardrobe.getBottomTrackCover() + ")";
    }
}
