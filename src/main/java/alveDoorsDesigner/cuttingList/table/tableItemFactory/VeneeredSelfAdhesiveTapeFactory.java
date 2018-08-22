package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class VeneeredSelfAdhesiveTapeFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.getVeeneredSelfAdhesiveTape(wardrobe.getDoorFrameColour()).getItemCode(),
                Product.getVeeneredSelfAdhesiveTape(wardrobe.getDoorFrameColour()).getName(),
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }
}
