package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SiliconBufferingDropsFactoryTest {

    SiliconBufferingDropsFactory factory = new SiliconBufferingDropsFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void siliconeBufferingDropsHaveNoDimention() {

        assertEquals("", factory.create(wardrobe).getDimention());
    }

    @Test
    public void numberOfSiliconeBufferingDrops_ShouldBe10TimesGraterThenTheNumberOfDoors() {

        assertEquals(wardrobe.getAmountOfDoors()*10, factory.create(wardrobe).getQuantity());
    }
}