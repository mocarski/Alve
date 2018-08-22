package alveDoorsDesigner.doorsDesigner.cavityDimention;

import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.numberOfDivisions.action.CreateNumberOfDivisionFieldsAction;
import alveDoorsDesigner.doorsDesigner.positioning.action.CreatePositioningOptionsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import alveDoorsDesigner.model.Wardrobe;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(EasyMockRunner.class)
public class NumberOfDoorsTest {
    @Mock
    UpdateVisibility updateVisibility;
    @Mock
    UpdateVisualization updateVisualization;
    @Mock
    CreateNumberOfDivisionFieldsAction createNumberOfDivisionFieldsAction;
    @Mock
    CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction;
    @Mock
    CreatePositioningOptionsAction createPositioningOptionsAction;

    private NumberOfDoors numberOfDoors;

    @Before
    public void setUp() throws Exception {
        numberOfDoors = new NumberOfDoors(new Wardrobe());
        numberOfDoors.setActions(updateVisibility, updateVisualization, createNumberOfDivisionFieldsAction,
                createFulfillmentTypeSelectsAction, createPositioningOptionsAction);
    }

    @Test
    public void numberOfDoorsIsNotValidWhenEmptyValue() {
        numberOfDoors.setValue("");
        assertFalse(numberOfDoors.isValid());
    }

    @Test
    public void maximumNumberOfDoorsIs7() {
        numberOfDoors.setValue("7");
        assertTrue(numberOfDoors.isValid());

        numberOfDoors.setValue("8");
        assertFalse(numberOfDoors.isValid());
    }

    @Test
    public void afterValueChange_VisualizationShouldBeUpdated() {
        updateVisualization.valueChange(anyObject());
        replay(updateVisualization);

        numberOfDoors.setValue("anyValue");
        verify(updateVisualization);
    }

    @Test
    public void afterValueChange_VisibilityOfDesignerSectionsShouldBeUpdated() {
        updateVisibility.valueChange(anyObject());
        replay(updateVisibility);

        numberOfDoors.setValue("anyValue");
        verify(updateVisibility);
    }

    @Test
    public void afterValueChange_NumberOfDivisionFieldsShouldBeCreated() {
        createNumberOfDivisionFieldsAction.valueChange(anyObject());
        replay(createNumberOfDivisionFieldsAction);

        numberOfDoors.setValue("anyValue");
        verify(createNumberOfDivisionFieldsAction);
    }

    @Test
    public void afterValueChange_FulfillmentTypeSelectsShouldBeCreated() {
        createFulfillmentTypeSelectsAction.valueChange(anyObject());
        replay(createFulfillmentTypeSelectsAction);

        numberOfDoors.setValue("anyValue");
        verify(createFulfillmentTypeSelectsAction);
    }

    @Test
    public void afterValueChange_PositioningOptionsSelectsShouldBeCreated() {
        createPositioningOptionsAction.valueChange(anyObject());
        replay(createPositioningOptionsAction);

        numberOfDoors.setValue("anyValue");
        verify(createPositioningOptionsAction);
    }
}