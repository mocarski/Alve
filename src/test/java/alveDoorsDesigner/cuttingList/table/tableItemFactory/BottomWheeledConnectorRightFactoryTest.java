package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BottomWheeledConnectorRightFactoryTest {

    BottomWheeledConnectorRightFactory factory = new BottomWheeledConnectorRightFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(5);
    }

    @Test
    public void rightBottomWheeledConnectorsHaveNoDimension() {
        assertEquals("", factory.create(wardrobe).getDimention());
    }

    @Test
    public void wardrobeHasTheSameNumberOfRightBottomWheeledConnectorsAsTheNumberOfDoors() {
        assertEquals(5, factory.create(wardrobe).getQuantity());
    }
}