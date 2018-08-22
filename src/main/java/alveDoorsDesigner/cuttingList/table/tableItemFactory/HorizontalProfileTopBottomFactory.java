package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class HorizontalProfileTopBottomFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        Product horizontalProfile = Product.getHorizontalProfile(wardrobe.getDoorFrameColour());
        return new TableItem(
                horizontalProfile.getItemCode(),
                horizontalProfile.getName(),
                Integer.toString(getWidthOfHorizontalProfile(wardrobe)),
                wardrobe.getAmountOfDoors() * 2);
    }

    private int getWidthOfHorizontalProfile(Wardrobe wardrobe) {
        return wardrobe.getDoors().get(0).getModules().get(0).getWidth();
    }
}
