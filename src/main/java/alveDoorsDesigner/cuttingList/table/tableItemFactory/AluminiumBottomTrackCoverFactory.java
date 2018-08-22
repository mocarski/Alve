package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class AluminiumBottomTrackCoverFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.ALUMINIUM_TRACK_COVER.getItemCode(),
                Product.ALUMINIUM_TRACK_COVER.getName(),
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }
}
