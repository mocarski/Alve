package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.model.WardrobeToolbox;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class PositionersFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.TOP_TRACK_DOOR_POSITIONER.getItemCode(),
                Product.TOP_TRACK_DOOR_POSITIONER.getName(),
                "",
                WardrobeToolbox.countNumberOfPositioners(wardrobe));
    }
}
