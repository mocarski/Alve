package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentType;
import alveDoorsDesigner.Constants;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardsFactory implements ListItemsFactory {
    @Override
    public List<TableItem> create(Wardrobe wardrobe) {

        Map<String, Integer> boards = new HashMap<>();

        for (Door door : wardrobe.getDoors()) {
            for (Module module : door.getModules()) {
                if (module.getFulfillmentType().equals(FulfillmentType.BOARD))
                    boards.merge(createFulfillmentDimension(module), 1, Integer::sum);
            }
        }

        List<TableItem> items = new ArrayList<>();

        for (Map.Entry<String, Integer> board : boards.entrySet()) {
            items.add(new TableItem(
                    Product.BOARD_8MM.getItemCode(),
                    Product.BOARD_8MM.getName(),
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
        return dimension + 2 * Constants.PLACE_TO_FILL_FULFILLMENT;
    }
}
