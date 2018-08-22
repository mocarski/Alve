package alveDoorsDesigner.doorsDesigner.numberOfDivisions;

import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateFulfillmentHeightTextFieldsAction;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.easymock.EasyMock.niceMock;
import static org.junit.Assert.*;

@RunWith(EasyMockRunner.class)
public class NumberOfDivisionsViewTest {

    private Wardrobe wardrobe = new Wardrobe();
    private HorizontalLayout layoutForTextFields = new HorizontalLayout();
    private int numberOfDoors = 2;

    @Before
    public void setUp() throws Exception {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(numberOfDoors);
    }

    @Test
    public void viewIsNotValid_WhenNumberOfDivisionTextFieldsAreNotCreated() throws Exception {
        NumberOfDivisionsView numberOfDivisionsView = new NumberOfDivisionsView(wardrobe,
                layoutForTextFields);

        assertFalse(numberOfDivisionsView.isValid());
    }

    @Test
    public void viewIsValid_ThenAllNumberOfDivisionTextFieldsAreValid() throws Exception {
        NumberOfDivisionsView numberOfDivisionsView = new NumberOfDivisionsView(wardrobe,
                layoutForTextFields);
        setActions(numberOfDivisionsView);

        numberOfDivisionsView.createNumberOfDivisionFieldForEachDoor();
        setValidValueForAllNumberOfDivisionTextFields(layoutForTextFields);

        assertTrue(numberOfDivisionsView.isValid());
    }

    @Test
    public void viewIsNotValid_ThenAtLeastOneNumberOfDivisionTextFieldIsNotValid() throws Exception {
        NumberOfDivisionsView numberOfDivisionsView = new NumberOfDivisionsView(wardrobe,
                layoutForTextFields);
        setActions(numberOfDivisionsView);

        numberOfDivisionsView.createNumberOfDivisionFieldForEachDoor();
        getInitializedNumberOfDivisionTextFields(layoutForTextFields).get(0).setValue("2");
        getInitializedNumberOfDivisionTextFields(layoutForTextFields).get(1).setValue("NotValidValue");

        assertFalse(numberOfDivisionsView.isValid());
    }

    @Test
    public void eachDoorShouldHaveCorrespondingNumberOfDivisionTextField() throws Exception {
        NumberOfDivisionsView numberOfDivisionsView = new NumberOfDivisionsView(wardrobe,
                layoutForTextFields);
        setActions(numberOfDivisionsView);

        numberOfDivisionsView.createNumberOfDivisionFieldForEachDoor();

        List<Door> bindedDoors = getBindedDoors(layoutForTextFields);
        for (Door door : wardrobe.getDoors())
            if (!bindedDoors.contains(door))
                fail("Each wardrobe door should have corresponding NumberOfDivisionTextField!");
    }

    private void setActions(NumberOfDivisionsView numberOfDivisionsView) {
        numberOfDivisionsView.setActions(niceMock(UpdateVisibility.class), niceMock
                (CreateFulfillmentTypeSelectsAction.class), niceMock
                (UpdateFulfillmentHeightTextFieldsAction.class), niceMock
                (UpdateVisualization.class));
    }

    private List<Door> getBindedDoors(HorizontalLayout layout) {
        List<Door> bindedDoors = new LinkedList<>();
        for (NumberOfDivisionsTextField textField : getInitializedNumberOfDivisionTextFields(layout)) {
            bindedDoors.add(textField.getBean());
        }
        return bindedDoors;
    }

    private List<NumberOfDivisionsTextField> getInitializedNumberOfDivisionTextFields(HorizontalLayout
                                                                                              layout) {
        List<NumberOfDivisionsTextField> fields = new LinkedList<>();
        for (Iterator<Component> it = layout.getComponentIterator(); it.hasNext(); ) {
            NumberOfDivisionsTextField textField = (NumberOfDivisionsTextField) it.next();
            //Value change just to initialize binding -> see NumberOfDivisionTextField class
            textField.setValue("2");
            fields.add(textField);
        }
        return fields;
    }

    private void setValidValueForAllNumberOfDivisionTextFields(HorizontalLayout layout) {
        for (Iterator<Component> it = layout.getComponentIterator(); it.hasNext(); )
            ((NumberOfDivisionsTextField) it.next()).setValue("2");
    }
}