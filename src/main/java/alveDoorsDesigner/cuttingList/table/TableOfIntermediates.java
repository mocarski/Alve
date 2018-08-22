package alveDoorsDesigner.cuttingList.table;

import alveDoorsDesigner.cuttingList.table.model.TableItem;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Grid;

public class TableOfIntermediates extends Grid<TableItem> {
    public static TableOfIntermediates create() {
        TableOfIntermediates table = new TableOfIntermediates();
        table.addColumns();
        table.setHeightEnoughToDoNotScrollTable();
        table.setWidth(70, Unit.PERCENTAGE);

        return table;
    }

    private void addColumns() {
        addColumn(TableItem::getItemCode).setCaption(Constants.ITEM_CODE);
        addColumn(TableItem::getName).setCaption(Constants.NAME);
        addColumn(TableItem::getDimention).setCaption(Constants.DIMENTION);
        addColumn(TableItem::getQuantity).setCaption(Constants.QUANTITY);
    }

    private void setHeightEnoughToDoNotScrollTable() {
        setHeightMode(HeightMode.UNDEFINED);
    }

}
