package alveDoorsDesigner.doorsDesigner.numberOfDivisions;

import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateFulfillmentHeightTextFieldsAction;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import alveDoorsDesigner.model.Door;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(EasyMockRunner.class)
public class NumberOfDivisionsTextFieldTest {

    @Mock
    UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction;
    @Mock
    CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction;
    @Mock
    UpdateVisualization updateVisualization;
    @Mock
    UpdateVisibility updateVisibility;

    private NumberOfDivisionsTextField numberOfDivisionsTextField;

    @Before
    public void setUp() throws Exception {
        numberOfDivisionsTextField = new NumberOfDivisionsTextField(new Door(1000, 2000),
                updateFulfillmentHeightTextFieldsAction, createFulfillmentTypeSelectsAction,
                updateVisualization, updateVisibility);
    }

    @Test
    public void numberOfDivisionsIsNotValidWhenEmptyValue() throws Exception {
        numberOfDivisionsTextField.setValue("");
        assertFalse(numberOfDivisionsTextField.isValid());
    }

    @Test
    public void maximumNumberOfDivisionsIs5(){
        numberOfDivisionsTextField.setValue("5");
        assertTrue(numberOfDivisionsTextField.isValid());

        numberOfDivisionsTextField.setValue("6");
        assertFalse(numberOfDivisionsTextField.isValid());
    }

    @Test
    public void afterValueChange_VisualizationShouldBeUpdated(){
        updateVisualization.valueChange(anyObject());
        replay(updateVisualization);

        numberOfDivisionsTextField.setValue("anyValue");
        verify(updateVisualization);
    }

    @Test
    public void afterValueChange_VisibilityOfDesignerSectionsShouldBeUpdated(){
        updateVisibility.valueChange(anyObject());
        replay(updateVisibility);

        numberOfDivisionsTextField.setValue("anyValue");
        verify(updateVisibility);
    }

    @Test
    public void afterValueChange_FulfillmentHeightFieldsShouldBeUpdated(){
        updateFulfillmentHeightTextFieldsAction.valueChange(anyObject());
        replay(updateFulfillmentHeightTextFieldsAction);

        numberOfDivisionsTextField.setValue("anyValue");
        verify(updateFulfillmentHeightTextFieldsAction);
    }

    @Test
    public void afterValueChange_FulfillmentTypeSelectsShouldBeCreated(){
        createFulfillmentTypeSelectsAction.valueChange(anyObject());
        replay(createFulfillmentTypeSelectsAction);

        numberOfDivisionsTextField.setValue("anyValue");
        verify(createFulfillmentTypeSelectsAction);
    }
}