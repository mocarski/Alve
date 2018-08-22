package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class TopWheeledConnectorsRightFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {

        return new TableItem(
                Product.TOP_WHEELED_CONNECTOR_RIGHT.getItemCode(),
                Product.TOP_WHEELED_CONNECTOR_RIGHT.getName(),
                "",
                wardrobe.getDoors().size());
    }
}
