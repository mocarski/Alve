package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class SteelDoubleTopTrackFactory implements ListItemFactory {

    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.STEEL_DOUBLE_TOP_TRACK.getItemCode(),
                Product.STEEL_DOUBLE_TOP_TRACK.getName(),
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }
}
