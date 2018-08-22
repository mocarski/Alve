package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class BottomWheeledConnectorLeftFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {

        return new TableItem(
                Product.BOTTOM_WHEELED_CONNECTOR_LEFT.getItemCode(),
                Product.BOTTOM_WHEELED_CONNECTOR_LEFT.getName(),
                "",
                wardrobe.getDoors().size());
    }
}
