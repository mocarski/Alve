package com.jm.ui.componentsList.factory;

import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.model.enums.PositioningOption;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class PositionersAndDumpersFactory implements ListItemsFactory{
    @Override
    public List<ListItem> create(Wardrobe wardrobe) {

        List<ListItem> items = new ArrayList<>();

        int numberOfPositioners = 0;
        int numberOfDumpers = 0;

        for (Door door : wardrobe.getDoors()) {
            if (PositioningOption.Positioners.equals(door.getPositioningOption())) {
                numberOfPositioners++;
            } else if (PositioningOption.Dumpers.equals(door.getPositioningOption())) {
                numberOfDumpers++;
            }
        }

        if (numberOfPositioners != 0)
            items.add(new ListItem(
                    "PTG01",
                    Constants.TOP_TRACK_DOOR_POSITIONER,
                    "",
                    numberOfPositioners));

        if (numberOfDumpers != 0) {
            items.add(new ListItem(
                    "SF001",
                    Constants.SOFT_CLOSE_DUMPER,
                    "",
                    numberOfDumpers));

            items.add(new ListItem(
                    "",
                    Constants.SOFT_CLOSE_DUMPER_ACTIVATOR,
                    "",
                    numberOfDumpers));

            items.add(new ListItem(
                    "",
                    Constants.PVC,
                    Constants.PVC_DIMENSION,
                    numberOfDumpers * 2));
        }

        return items;
    }
}
