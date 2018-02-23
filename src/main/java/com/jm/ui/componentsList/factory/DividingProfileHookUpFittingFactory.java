package com.jm.ui.componentsList.factory;

import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

public class DividingProfileHookUpFittingFactory implements ListItemFactory{
    @Override
    public ListItem create(Wardrobe wardrobe) {
        return new ListItem(
                "OLP",
                Constants.DIVIDING_PROFILE_HOOKUP_FITTING,
                "",
                countNumberOfDividingProfiles(wardrobe));
    }

    private int countNumberOfDividingProfiles(Wardrobe wardrobe) {
        int numberOfDividingProfiles = 0;
        for (Door door : wardrobe.getDoors()) {
            numberOfDividingProfiles += 2* door.getAmountOfDivisions();
        }

        return numberOfDividingProfiles;
    }
}
