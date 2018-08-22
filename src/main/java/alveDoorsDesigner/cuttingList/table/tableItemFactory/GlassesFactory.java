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

public class GlassesFactory implements ListItemsFactory {
    @Override
    public List<TableItem> create(Wardrobe wardrobe) {

        Map<String, Integer> glasses = new HashMap<>();

        for (Door door : wardrobe.getDoors()) {
            for (Module module : door.getModules()) {
                if (module.getFulfillmentType().equals(FulfillmentType.GLASS))
                    glasses.merge(createFulfillmentDimension(module), 1, Integer::sum);
            }
        }

        List<TableItem> items = new ArrayList<>();

        for (Map.Entry<String, Integer> glass : glasses.entrySet()) {
            items.add(new TableItem(
                    Product.GLASS_4MM.getItemCode(),
                    Product.GLASS_4MM.getName(),
                    glass.getKey(),
                    glass.getValue()));
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
