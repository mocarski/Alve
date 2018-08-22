package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class BottomWheeledConnectorRightFactory implements ListItemFactory {

    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.BOTTOM_WHEELED_CONNECTOR_RIGHT.getItemCode(),
                Product.BOTTOM_WHEELED_CONNECTOR_RIGHT.getName(),
                "",
                wardrobe.getDoors().size());
    }
}
