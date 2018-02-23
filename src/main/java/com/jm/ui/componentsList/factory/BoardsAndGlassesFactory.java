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

public class BoardsAndGlassesFactory implements ListItemsFactory {
    @Override
    public List<ListItem> create(Wardrobe wardrobe) {

        Map<String, Integer> boards = new HashMap<>();
        Map<String, Integer> glasses = new HashMap<>();

        for (Door door : wardrobe.getDoors()) {
            for (Module module : door.getModules()) {

                String dimention = createFulfillmentDimension(module);

                if (module.getFulfillment().equals(Fulfillment.GLASS))
                    glasses.merge(dimention, 1, Integer::sum);
                else
                    boards.merge(dimention, 1, Integer::sum);

            }
        }

        List<ListItem> items = new ArrayList<>();

        for (Map.Entry<String, Integer> glass : glasses.entrySet()) {
            items.add(new ListItem(
                    "",
                    Constants.GLASS_4MM,
                    glass.getKey(),
                    glass.getValue()));
        }
        for (Map.Entry<String, Integer> board : boards.entrySet()) {
            items.add(new ListItem(
                    "",
                    Constants.BOARD_8MM,
                    board.getKey(),
                    board.getValue()));
        }

        return items;
    }

    private String createFulfillmentDimension(Module module) {
        return String.format("%s/%s", addPlaceForFulfillment(module.getWidth()),
                addPlaceForFulfillment(module.getHeight()));
    }

    private int addPlaceForFulfillment(int dimension) {
        return dimension + 2 * Constants.PLACE_FOR_FULFILLMENT;
    }
}
