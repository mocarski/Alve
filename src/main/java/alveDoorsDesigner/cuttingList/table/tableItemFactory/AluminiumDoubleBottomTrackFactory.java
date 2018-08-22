package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class AluminiumDoubleBottomTrackFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.ALUMINIUM_DOUBLE_BOTTOM_TRACK.getItemCode(),
                Product.ALUMINIUM_DOUBLE_BOTTOM_TRACK.getName(),
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }
}
