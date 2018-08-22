package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopTrackFacioSelectFactoryTest {
    TopTrackFacioFactory factory = new TopTrackFacioFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void widthOfTopTrackFacioShouldBeTheSameAsWidthOfWardrobeCavity() {
        assertEquals(Integer.toString(wardrobe.getCavityWidth()), factory.create(wardrobe).getDimention());
    }

    @Test
    public void wardrobeAlwaysHasOnlyOneTopTrackFacio() {
        assertEquals(1, factory.create(wardrobe).getQuantity());
    }
}