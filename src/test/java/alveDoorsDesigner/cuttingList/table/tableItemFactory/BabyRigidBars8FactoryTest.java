package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentType;
import alveDoorsDesigner.cuttingList.table.model.TableItem;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

@RunWith(EasyMockRunner.class)
public class BabyRigidBars8FactoryTest {
    RigidBars8Factory factory = new RigidBars8Factory();
    Wardrobe wardrobe = new Wardrobe();

    @Mock
    private RigidBarLengthCalculator calculator;

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

        setBoardAsFulfillmentForEachModule();
    }

    @Test
    public void numberOfRigidBars8ShouldBeTwiceAsLargeAsNumberOfModulesInWardrobe() {
        List<TableItem> tableItems = factory.create(wardrobe);

        int numberOfRigidBars8 = 0;
        for (TableItem tableItem : tableItems) {
            numberOfRigidBars8 += tableItem.getQuantity();
        }
        assertEquals(numberOfDoors * numberOfModules * 2, numberOfRigidBars8);
        // For one module two rigid bars are needed
    }

    @Test
    public void orderOfListItemsShouldBeFromTheShortestToTheLongest() {
        expect(calculator.calculate(anyObject(), anyObject()))
                .andReturn(44)
                .andReturn(33)
                .andReturn(66)
                .andReturn(22)
                .andReturn(77)
                .andReturn(55);
        replay(calculator);

        List<TableItem> tableItems = factory.create(wardrobe, calculator);
        assertEquals("22", tableItems.get(0).getDimention());
        assertEquals("33", tableItems.get(1).getDimention());
        assertEquals("44", tableItems.get(2).getDimention());
        assertEquals("55", tableItems.get(3).getDimention());
        assertEquals("66", tableItems.get(4).getDimention());
        assertEquals("77", tableItems.get(5).getDimention());
    }

    @Test
    public void allRigidBars8InTheSameDimentionShouldBeSummarizedAndVisibleAsOneListItem() {
        expect(calculator.calculate(anyObject(), anyObject()))
                .andReturn(44)
                .andReturn(57)
                .andReturn(44)
                .andReturn(73)
                .andReturn(87)
                .andReturn(44);
        replay(calculator);

        List<TableItem> tableItems = factory.create(wardrobe, calculator);
        assertEquals("44", tableItems.get(0).getDimention());
        assertEquals(6, tableItems.get(0).getQuantity());
    }

    @Test
    public void whenManyRigidBars8InDiffrentAndSameSizes_ThenAllOfRigidBars8ShouldBePresentInList() {
        expect(calculator.calculate(anyObject(), anyObject()))
                .andReturn(57)
                .andReturn(97)
                .andReturn(67)
                .andReturn(77)
                .andReturn(87)
                .andReturn(97);
        replay(calculator);

        List<TableItem> tableItems = factory.create(wardrobe, calculator);
        assertEquals(numberOfDoors * numberOfModules - 1, tableItems.size());
        assertEquals("57", tableItems.get(0).getDimention());
        assertEquals(2, tableItems.get(0).getQuantity());
        assertEquals("67", tableItems.get(1).getDimention());
        assertEquals(2, tableItems.get(1).getQuantity());
        assertEquals("77", tableItems.get(2).getDimention());
        assertEquals(2, tableItems.get(2).getQuantity());
        assertEquals("87", tableItems.get(3).getDimention());
        assertEquals(2, tableItems.get(3).getQuantity());
        assertEquals("97", tableItems.get(4).getDimention());
        assertEquals(4, tableItems.get(4).getQuantity());
    }

    private void setBoardAsFulfillmentForEachModule() {
        for(Door door: wardrobe.getDoors()){
            for(Module module : door.getModules()){
                module.setFulfillmentType(FulfillmentType.BOARD);
            }
        }
    }
}