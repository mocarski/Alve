package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerticalProfilesRightFactoryTest {
    VerticalProfilesRightFactory factory = new VerticalProfilesRightFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void numberOfVerticalProfilesRightShouldBeTheSameAsNumberOfDoors() {
        assertEquals(wardrobe.getAmountOfDoors(), factory.create(wardrobe).getQuantity());
    }

    @Test
    public void lengthOfVerticalProfilesRightShouldBeTheSameAsDoorsHeight() {
        assertEquals(Integer.toString(wardrobe.getDoorsHeight()), factory.create(wardrobe).getDimention());
    }
}