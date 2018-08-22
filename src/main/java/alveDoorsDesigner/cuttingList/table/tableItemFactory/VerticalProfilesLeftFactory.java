package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class VerticalProfilesLeftFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        Product verticalProfileLeft = Product.getVerticalProfileLeft(wardrobe.getDoorFrameColour());

        return new TableItem(
                verticalProfileLeft.getItemCode(),
                verticalProfileLeft.getName(),
                Integer.toString(wardrobe.getDoorsHeight()),
                wardrobe.getAmountOfDoors());
    }
}
