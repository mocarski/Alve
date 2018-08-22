package alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action;

import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.FulfillmentHeightView;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@RunWith(EasyMockRunner.class)
public class UpdateFulfillmentHeightTextFieldsActionTest {

    @Mock
    FulfillmentHeightView fulfillmentHeightView;

    @Test
    public void whenActionTriggered_ThenFulfillmentHeightTextFieldsShouldBeCreated() throws Exception {
        fulfillmentHeightView.createFulfillmentHeightTextFields();
        replay(fulfillmentHeightView);
        UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction = new
                UpdateFulfillmentHeightTextFieldsAction(fulfillmentHeightView);

        updateFulfillmentHeightTextFieldsAction.valueChange(null);

        verify(fulfillmentHeightView);
    }
}