package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.positioning.PositioningOption;
import alveDoorsDesigner.cuttingList.table.model.TableItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionersFactoryTest {
    Wardrobe wardrobe = new Wardrobe();
    PositionersFactory factory = new PositionersFactory();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(5);
    }

    @Test
    public void positionerHasNoDimension() {
        TableItem item = factory.create(wardrobe);

        assertEquals("", item.getDimention());
    }

    @Test
    public void numberOfPositionersShouldBeEqualToPositionersAssignedToAllWardrobeDoors() {
        wardrobe.getDoors().get(0).setPositioningOption(PositioningOption.Positioner);
        wardrobe.getDoors().get(3).setPositioningOption(PositioningOption.Positioner);

        TableItem item = factory.create(wardrobe);
        assertEquals(2, item.getQuantity());
    }
}