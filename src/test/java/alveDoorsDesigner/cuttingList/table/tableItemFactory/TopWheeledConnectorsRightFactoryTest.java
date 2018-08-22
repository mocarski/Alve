package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopWheeledConnectorsRightFactoryTest {
    TopWheeledConnectorsRightFactory factory = new TopWheeledConnectorsRightFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void topWheeledConnectorRightHasNoDimention() {
        assertEquals("", factory.create(wardrobe).getDimention());
    }

    @Test
    public void numberOfTopWheeledConnectorsRightShouldBeTheSameAsNumberOfDoors() {
        assertEquals(wardrobe.getAmountOfDoors(), factory.create(wardrobe).getQuantity());
    }
}