package alveDoorsDesigner.doorsDesigner.fulfillmentType.action;

import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentTypeView;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@RunWith(EasyMockRunner.class)
public class CreateFulfillmentTypeSelectsActionTest {

    @Mock
    FulfillmentTypeView fulfillmentTypeView;

    @Test
    public void whenActionTriggered_ThenFulfillmentTypeSelectsShouldBeCreated() throws Exception {
        fulfillmentTypeView.createFulfillmentTypeSelects();
        replay(fulfillmentTypeView);
        CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction = new
                CreateFulfillmentTypeSelectsAction(fulfillmentTypeView);

        createFulfillmentTypeSelectsAction.valueChange(null);

        verify(fulfillmentTypeView);
    }
}