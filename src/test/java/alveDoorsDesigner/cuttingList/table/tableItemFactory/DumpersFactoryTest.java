package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.positioning.PositioningOption;
import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.cuttingList.table.model.TableItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DumpersFactoryTest {

    Wardrobe wardrobe = new Wardrobe();
    DumpersFactory factory = new DumpersFactory();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);

        setDumperAsPositioningOptionForSecondAndThirdDoors();
    }

    @Test
    public void dumperConsistsOfThreeElements() {
        List<TableItem> items = factory.create(wardrobe);

        assertEquals(3, items.size());
    }

    @Test
    public void softCloseDumperHasNoDimention() {
        List<TableItem> items = factory.create(wardrobe);

        TableItem softCloseDumper = findItem(items, Product.SOFT_CLOSE_DUMPER.getName());
        assertEquals("", softCloseDumper.getDimention());
    }


    @Test
    public void SoftCloseDumperActivatorHasNoDimention() {
        List<TableItem> items = factory.create(wardrobe);

        TableItem softCloseDumperActivator = findItem(items, Product.SOFT_CLOSE_DUMPER_ACTIVATOR.getName());
        assertEquals("", softCloseDumperActivator.getDimention());
    }


    @Test
    public void pvcHasDimention() {
        List<TableItem> items = factory.create(wardrobe);

        TableItem softCloseDumper = findItem(items, Product.PVC.getName());
        assertEquals(Constants.PVC_DIMENSION, softCloseDumper.getDimention());
    }

    @Test
    public void numberOfSoftCloseDumpersShouldBeEqualToDumpersAssignedToDoors() {
        List<TableItem> items = factory.create(wardrobe);

        TableItem softCloseDumper = findItem(items, Product.SOFT_CLOSE_DUMPER.getName());
        assertEquals(2, softCloseDumper.getQuantity());
    }

    @Test
    public void numberOfSoftCloseDumperActivatorsShouldBeEqualToDumpersAssignedToDoors() {
        List<TableItem> items = factory.create(wardrobe);

        TableItem softCloseDumperActivator = findItem(items, Product.SOFT_CLOSE_DUMPER_ACTIVATOR.getName());
        assertEquals(2, softCloseDumperActivator.getQuantity());
    }

    @Test
    public void numberOfPVCShouldBeTwiceAsLargeAsNumberOfDumpersAssignedToDoors() {
        List<TableItem> items = factory.create(wardrobe);

        TableItem softCloseDumperActivator = findItem(items, Product.PVC.getName());
        assertEquals(4, softCloseDumperActivator.getQuantity());
    }

    private void setDumperAsPositioningOptionForSecondAndThirdDoors() {
        for (Door door : wardrobe.getDoors().subList(1, 3))
            door.setPositioningOption(PositioningOption.Dumper);
    }

    private TableItem findItem(List<TableItem> items, String itemName) {
        for (TableItem item : items) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }
}