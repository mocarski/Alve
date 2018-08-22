package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class VerticalProfilesRightFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        Product verticalProfileRight = Product.getVerticalProfileRight(wardrobe.getDoorFrameColour());
        return new TableItem(
                verticalProfileRight.getItemCode(),
                verticalProfileRight.getName(),
                Integer.toString(wardrobe.getDoorsHeight()),
                wardrobe.getAmountOfDoors());
    }
}
