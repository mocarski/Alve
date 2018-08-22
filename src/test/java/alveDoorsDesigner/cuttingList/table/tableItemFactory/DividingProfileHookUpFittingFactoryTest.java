package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DividingProfileHookUpFittingFactoryTest {
    DividingProfileHookUpFittingFactory factory = new DividingProfileHookUpFittingFactory();
    Wardrobe wardrobe = new Wardrobe();

    int numberOfDoors = 3;
    int numberOfDivisions = 2;

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(numberOfDoors);
    }

    @Test
    public void dividingProfileHookUpFittingDoesNotHaveDimension() {
        assertEquals("", factory.create(wardrobe).getDimention());
    }

    @Test
    public void
    wardrobeShouldHaveTwoTimesMoreDividingProfileHookUpFittingThenTheNumberOfDivisionsOfEachDoor() {
        for (Door door : wardrobe.getDoors()) {
            door.setAmountOfDivision(numberOfDivisions);
        }

        assertEquals(2 * numberOfDoors * numberOfDivisions, factory.create(wardrobe).getQuantity());
    }
}