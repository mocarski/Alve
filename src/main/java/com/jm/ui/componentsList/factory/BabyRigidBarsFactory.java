package com.jm.ui.componentsList.factory;

import com.jm.model.Module;
import com.jm.model.Door;
import com.jm.model.Wardrobe;
import com.jm.model.enums.Fulfillment;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class BabyRigidBarsFactory implements ListItemsFactory {
    @Override
    public List<ListItem> create(Wardrobe wardrobe) {

        int babyRigidBar4 = 0;
        int babyRigidBar8 = 0;

        for (Door door : wardrobe.getDoors()) {
            for (Module module : door.getModules()) {
                if (module.getFulfillment().equals(Fulfillment.GLASS)) {
                        babyRigidBar4 += 3;
                }
                else{
                        babyRigidBar8 += 3;
                }
            }
        }

        List<ListItem> items = new ArrayList<>();

        if(babyRigidBar4 != 0) {
            items.add(new ListItem(
                    "BRB-04",
                    Constants.BABY_RIGID_BAR_4_MM_FILLINGS,
                    "",
                    babyRigidBar4));
        }

        if(babyRigidBar8 != 0) {
            items.add(new ListItem(
                    "BRB-08",
                    Constants.BABY_RIGID_BAR_8_MM_FILLINGS,
                    "",
                    babyRigidBar8));
        }

        return items;
    }
}
