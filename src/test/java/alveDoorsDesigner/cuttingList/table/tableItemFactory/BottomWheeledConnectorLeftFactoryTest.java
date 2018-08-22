package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BottomWheeledConnectorLeftFactoryTest {

    BottomWheeledConnectorLeftFactory factory = new BottomWheeledConnectorLeftFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void leftBottomWheeledConnectorsHaveNoDimension() {
        assertEquals("", factory.create(wardrobe).getDimention());
    }

    @Test
    public void wardrobeHasTheSameNumberOfLeftBottomWheeledConnectorsAsTheNumberOfDoors() {
        assertEquals(3, factory.create(wardrobe).getQuantity());
    }
}