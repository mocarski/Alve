package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SelfTappingWoodScrewFactoryTest {
    SelfTappingWoodScrewFactory factory = new SelfTappingWoodScrewFactory();
    Wardrobe wardrobe = new Wardrobe();

    int numberOfDoors = 3;
    int numberOfModules = 2;

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(numberOfDoors);
        for (Door door : wardrobe.getDoors()) {
            door.setAmountOfModules(numberOfModules);
        }
    }

    @Test
    public void twoListItemsShouldBeCreated_OneFor3MM16MM_AndOneFor3MM25MM() {
        List<TableItem> tableItems = factory.create(wardrobe);

        assertEquals(2, tableItems.size());
        assertEquals(alveDoorsDesigner.doorsDesigner.Constants._3MM_16MM, tableItems.get(0).getDimention());
        assertEquals(Constants._3MM_25MM, tableItems.get(1).getDimention());
    }

    @Test
    public void
    toAssembleTheDoor_8screwIsNeededAnd2MoreForEachDivision_ScrewsOfBothTypesAreNeededInTheSameAmount() {
        List<TableItem> tableItems = factory.create(wardrobe);

        int numberOfNeededScrews = numberOfDoors * 8 + numberOfDoors * (numberOfModules - 1) * 2;
        assertEquals(Constants._3MM_16MM, tableItems.get(0).getDimention());
        assertEquals(numberOfNeededScrews, tableItems.get(0).getQuantity());
        assertEquals(Constants._3MM_25MM, tableItems.get(1).getDimention());
        assertEquals(numberOfNeededScrews, tableItems.get(1).getQuantity());
    }
}