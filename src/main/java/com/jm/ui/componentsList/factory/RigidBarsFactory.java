package com.jm.ui.componentsList.factory;

import com.jm.model.Module;
import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.model.WardrobeToolbox;
import com.jm.model.enums.Fulfillment;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RigidBarsFactory implements ListItemsFactory {
    @Override
    public List<ListItem> create(Wardrobe wardrobe) {

        Map<Integer, Integer> rigidBars4 = new HashMap<>();
        Map<Integer, Integer> rigidBars8 = new HashMap<>();
        int rigidBarLength = 0;

        for (Door door : wardrobe.getDoors())
            for (Module module : door.getModules()) {
                if ( WardrobeToolbox.isSingleModule(door, module) ) {
                    rigidBarLength = door.getHeight() - Constants.PLACE_FOR_TOP_WHEEL
                            - Constants.PLACE_FOR_BOTTOM_WHEEL - 2 * Constants.SPACE;
                } else if (WardrobeToolbox.isTopModule(door, module)) {
                    rigidBarLength = module.getHeight() -
                            Constants.PLACE_FOR_TOP_WHEEL_CONFLICTED_WITH_MODULE
                            + Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR - 2 * Constants.SPACE;
                } else if (WardrobeToolbox.isBottomModule(door, module)) {
                    rigidBarLength = module.getHeight() -
                            Constants.PLACE_FOR_BOTTOM_WHEEL_CONFLICTED_WITH_MODULE
                            + Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR - 2 * Constants.SPACE;
                } else {
                    rigidBarLength = module.getHeight() + 2*Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR;
                }

                if (module.getFulfillment().equals(Fulfillment.GLASS))
                    rigidBars4.merge(rigidBarLength, 2, Integer::sum);
                else
                    rigidBars8.merge(rigidBarLength, 2, Integer::sum);
            }

        List<ListItem> items = new ArrayList<>();

        for (Map.Entry<Integer, Integer> rigidBar4 : rigidBars4.entrySet())
            items.add(new ListItem(
                    "TT1504",
                    Constants.RIGID_BAR_TT_4_MM_FILLINGS,
                    Integer.toString(rigidBar4.getKey()),
                    rigidBar4.getValue()));


        for (Map.Entry<Integer, Integer> rigidBar8 : rigidBars8.entrySet())
            items.add(new ListItem(
                    "TT1508",
                    Constants.RIGID_BAR_TT_8_MM_FILLINGS,
                    Integer.toString(rigidBar8.getKey()),
                    rigidBar8.getValue()));

        return items;
    }
}
