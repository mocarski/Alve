package alveDoorsDesigner.doorsDesigner.numberOfDivisions.action;

import alveDoorsDesigner.doorsDesigner.numberOfDivisions.NumberOfDivisionsView;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@RunWith(EasyMockRunner.class)
public class CreateNumberOfDivisionFieldsActionTest {

    @Mock
    NumberOfDivisionsView numberOfDivisionsView;

    @Test
    public void whenActionTriggered_ThenNumberOfDivisionFieldShouldBeCreatedForEachDoor() throws Exception {
        numberOfDivisionsView.createNumberOfDivisionFieldForEachDoor();
        replay(numberOfDivisionsView);
        CreateNumberOfDivisionFieldsAction createNumberOfDivisionFieldsAction = new
                CreateNumberOfDivisionFieldsAction(numberOfDivisionsView);

        createNumberOfDivisionFieldsAction.valueChange(null);

        verify(numberOfDivisionsView);
    }
}