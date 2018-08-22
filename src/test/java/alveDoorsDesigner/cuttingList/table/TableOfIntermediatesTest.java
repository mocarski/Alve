package alveDoorsDesigner.cuttingList.table;

import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Grid.Column;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableOfIntermediatesTest {
    TableOfIntermediates table = TableOfIntermediates.create();

    @Test
    public void ItemCodeShouldBeTheFirstColumn() throws Exception {
        Column column = table.getColumns().get(0);

        assertEquals(Constants.ITEM_CODE, column.getCaption());
    }

    @Test
    public void NameShouldBeTheSecondColumn() throws Exception {
        Column column = table.getColumns().get(1);

        assertEquals(Constants.NAME, column.getCaption());
    }

    @Test
    public void DimensionShouldBeTheThirdColumn() throws Exception {
        Column column = table.getColumns().get(2);

        assertEquals(Constants.DIMENTION, column.getCaption());
    }

    @Test
    public void QuantityShouldBeTheFourthColumn() throws Exception {
        Column column = table.getColumns().get(3);

        assertEquals(Constants.QUANTITY, column.getCaption());
    }

    @Test
    public void TableShouldBeOfSuchHeightThatVerticalScrollingIsNotNeeded() throws Exception {
        assertEquals(HeightMode.UNDEFINED, table.getHeightMode());
    }

    @Test
    public void WidthOfTableShouldBeSetTo70PercentOfParentComponentWidth() throws Exception {
        assertEquals(70l,table.getWidth(), 0.1);
        assertEquals(Sizeable.Unit.PERCENTAGE, table.getWidthUnits());
    }
}