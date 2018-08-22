package alveDoorsDesigner.doorsDesigner.fulfillmentHeight;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

@RunWith(EasyMockRunner.class)
public class FulfillmentHeightValidatorTest {

    @Mock
    Door door;

    private int targetHeightOfModules = 2000;

    private List<Module> modules = new LinkedList<>();
    private Module module1 = new Module(1000, targetHeightOfModules / 2);
    private Module module2 = new Module(1000, targetHeightOfModules / 2);

    @Before
    public void setUp() throws Exception {
        modules.add(module1);
        modules.add(module2);
        expect(door.getModules()).andReturn(modules).anyTimes();
        expect(door.calculateTargetHeightOfModules()).andReturn(targetHeightOfModules).anyTimes();
        replay(door);
    }

    @Test
    public void validationResultIsError_WhenSummaryHeightsOfModulesIsNotEqualToTargetHeightOfModulesInDoor() {
        FulfillmentHeightValidator validator = new FulfillmentHeightValidator(door, module1);

        assertTrue(validator.apply(900, null).isError());
    }

    @Test
    public void validationResultIsOK_WhenSummaryHeightsOfModulesIsEqualToTargetHeightOfModulesInDoor() {
        FulfillmentHeightValidator validator = new FulfillmentHeightValidator(door, module1);

        assertFalse(validator.apply(1000, null).isError());
    }

    @Test
    public void
    whenValidationResultIsError_ThenAnywayChangeModuleHeight_ToAllowChangingHeightOfOtherModulesToAchieveTargetHeightOfAllModulesInDoor
            () {
        FulfillmentHeightValidator validator = new FulfillmentHeightValidator(door, module1);

        validator.apply(900, null);
        assertEquals(900, module1.getHeight());
    }

    @Test
    public void changingHeightOfTwoModulesScenario() {
        FulfillmentHeightValidator validator1 = new FulfillmentHeightValidator(door, module1);
        FulfillmentHeightValidator validator2 = new FulfillmentHeightValidator(door, module2);

        assertTrue(validator1.apply(900, null).isError()); // 900 + 1000 != 2000
        assertFalse(validator2.apply(1100, null).isError()); // 900 + 1100 == 2000
        assertTrue(validator1.apply(800, null).isError()); // 800 + 1100 != 2000
        assertTrue(validator2.apply(500, null).isError()); //800 + 500 != 2000
        assertFalse(validator1.apply(1500, null).isError()); // 1500 + 500 == 2000
    }
}