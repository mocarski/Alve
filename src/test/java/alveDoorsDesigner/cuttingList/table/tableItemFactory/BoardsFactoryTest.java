package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentType;
import alveDoorsDesigner.Constants;
import alveDoorsDesigner.cuttingList.table.model.TableItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BoardsFactoryTest {

    Wardrobe wardrobe = new Wardrobe();
    BoardsFactory factory = new BoardsFactory();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(2);
    }

    @Test
    public void noBoardItemShouldBeCreated_WhenNoModulesWithBoardFulfillment() {

        List<TableItem> items = factory.create(wardrobe);

        assertEquals(0, items.size());
    }

    @Test
    public void amountOfBoardsInListShouldBeEqualToModulesWithBoardFulfillment_TheSameSizeOfBoards() {
        setBoardFulfillmentForAllModules();

        List<TableItem> items = factory.create(wardrobe);

        assertEquals(1, items.size());
        assertEquals(2, items.get(0).getQuantity());
    }

    @Test
    public void amountOfBoardsInListShouldBeEqualToModulesWithBoardFulfillment_DifferentSizeOfBoards() {
        wardrobe.getDoors().get(0).setAmountOfModules(2);
        wardrobe.getDoors().get(1).setAmountOfModules(3);
        setBoardFulfillmentForAllModules();

        List<TableItem> items = factory.create(wardrobe);

        assertEquals(2, items.size());
        assertEquals(5, items.get(0).getQuantity() + items.get(1).getQuantity());
    }

    @Test
    public void BoardFulfillmentShouldBeHigherAndWiderThenBoardGap() {
        int width = wardrobe.getDoors().get(0).getModules().get(0).getWidth();
        int height = wardrobe.getDoors().get(0).getModules().get(0).getHeight();
        setBoardFulfillmentForAllModules();

        List<TableItem> items = factory.create(wardrobe);

        int widthOfBoard = width + 2 * Constants.PLACE_TO_FILL_FULFILLMENT;
        int heightOfBoard = height + 2 * Constants.PLACE_TO_FILL_FULFILLMENT;
        assertEquals(widthOfBoard + "/" + heightOfBoard, items.get(0).getDimention());
    }


    private void setBoardFulfillmentForAllModules() {
        for (Door door : wardrobe.getDoors()) {
            for (Module module : door.getModules())
                module.setFulfillmentType(FulfillmentType.BOARD);
        }
    }
}