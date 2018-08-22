package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

import java.util.LinkedList;
import java.util.List;

public class SelfTappingWoodScrewFactory implements ListItemsFactory {
    @Override
    public List<TableItem> create(Wardrobe wardrobe) {

        List<TableItem> items = new LinkedList<>();

        items.add(new TableItem(
                Product.SELF_TAPPING_WOOD_SCREW_3MM_16MM.getItemCode(),
                Product.SELF_TAPPING_WOOD_SCREW_3MM_16MM.getName(),
                Constants._3MM_16MM,
                calculateAmountOfSelfTappingWoodScrew(wardrobe)));
        items.add(new TableItem(
                Product.SELF_TAPPING_WOOD_SCREW_3MM_25MM.getItemCode(),
                Product.SELF_TAPPING_WOOD_SCREW_3MM_25MM.getName(),
                Constants._3MM_25MM,
                calculateAmountOfSelfTappingWoodScrew(wardrobe)));

        return items;
    }

    private int calculateAmountOfSelfTappingWoodScrew(Wardrobe wardrobe) {
        int result = 0;

        for (Door door : wardrobe.getDoors()) {
            result = result + 8 + door.getNumberOfDivisions() * 2;
        }

        return result;
    }

}
