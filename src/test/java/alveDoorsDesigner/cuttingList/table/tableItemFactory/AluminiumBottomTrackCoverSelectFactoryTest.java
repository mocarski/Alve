package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AluminiumBottomTrackCoverSelectFactoryTest {

    private AluminiumBottomTrackCoverFactory factory = new AluminiumBottomTrackCoverFactory();

    @Test
    public void wardrobeAlwaysHasOnlyOneBottomTruckCover() {

        Wardrobe wardrobe = new Wardrobe();

        assertEquals(1, factory.create(wardrobe).getQuantity());
    }

    @Test
    public void lengthOfBottomTruckCoverIsEqualToWardrobeCavityWidth() {

        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setCavityWidth(2000);

        assertEquals("2000", factory.create(wardrobe).getDimention());
    }
}