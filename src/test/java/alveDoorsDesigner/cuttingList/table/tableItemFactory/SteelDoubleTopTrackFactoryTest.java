package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import static org.junit.Assert.assertEquals;
import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;


public class SteelDoubleTopTrackFactoryTest {

    SteelDoubleTopTrackFactory factory = new SteelDoubleTopTrackFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void wardrobeAlwaysHasOnlyOneSteelDoubleTopTrack() {
        assertEquals(1, factory.create(wardrobe).getQuantity());
    }

    @Test
    public void lengthOfSteelDoubleTopTruckShouldBeTheSameAsWidthOfWardrobeCavity() {
        assertEquals(Integer.toString(wardrobe.getCavityWidth()), factory.create(wardrobe).getDimention());
    }
}