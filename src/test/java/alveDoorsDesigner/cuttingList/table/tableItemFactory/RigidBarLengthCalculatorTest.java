package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import alveDoorsDesigner.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RigidBarLengthCalculatorTest {
    private RigidBarLengthCalculator calculator = new RigidBarLengthCalculator(new ModulePositionDetector());
    private Door door;

    @Before
    public void setUp() throws Exception {
        door = new Door(500, 2100);
    }

    @Test
    public void
    inCaseOfSingleModule_RigidBarLengthShouldBeShorterThenHeightOfDoor_BecauseOfPlaceNeededForTopWheelElementBottomWheelElementAnd2SpacesBetweenAll3Elements() {
        assertEquals(door.getHeight() - Constants.PLACE_FOR_TOP_WHEEL - Constants.PLACE_FOR_BOTTOM_WHEEL - 2 *
                Constants.SPACE, calculator.calculate(door, door.getModules().get(0)));
    }

    @Test
    public void
    InCaseOfTopModule_RigidBarLengthShouldBeShorterThenHeightOfTopModule_BecauseTopWheelAndDividingProfileMustBeTakenIntoAccout() {
        door.setAmountOfModules(3);

        int rigidBarLength = getHeightOfTopModule(door) -
                Constants.PLACE_FOR_TOP_WHEEL_CONFLICTED_WITH_MODULE
                + Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR - 2 * Constants.SPACE;

        assertEquals(rigidBarLength, calculator.calculate(door, getTopModule(door)));
    }

    @Test
    public void
    InCaseOfBottomModule_RigidBarLengthShouldBeShorterThenHeightOfBottomModule_BecauseBottomWheelAndDividingProfileMustBeTakenIntoAccout() {
        door.setAmountOfModules(3);

        int rigidBarLength = getHeightOfBottomModule(door) -
                Constants.PLACE_FOR_BOTTOM_WHEEL_CONFLICTED_WITH_MODULE
                + Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR - 2 * Constants.SPACE;

        assertEquals(rigidBarLength, calculator.calculate(door, getBottomModule(door)));
    }

    @Test
    public void
    InCaseOfMiddleModule_RigidBarLengthShouldBeLongerThenHeightOfMiddleModule_BecauseDividingProfilesMustBeTakenIntoAccount() {
        door.setAmountOfModules(3);

        int rigidBarLength = getHeightOfMiddleModule(door) + 2 * Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR;

        assertEquals(rigidBarLength, calculator.calculate(door, getMiddleModule(door)));
    }

    private Module getTopModule(Door door) {
        return door.getModules().get(0);
    }

    private Module getMiddleModule(Door door) {
        return door.getModules().get(1);
    }

    private Module getBottomModule(Door door) {
        return door.getModules().get(2);
    }

    private int getHeightOfTopModule(Door door) {
        return door.getModules().get(0).getHeight();
    }

    private int getHeightOfMiddleModule(Door door) {
        return door.getModules().get(1).getHeight();
    }

    private int getHeightOfBottomModule(Door door) {
        return door.getModules().get(2).getHeight();
    }
}