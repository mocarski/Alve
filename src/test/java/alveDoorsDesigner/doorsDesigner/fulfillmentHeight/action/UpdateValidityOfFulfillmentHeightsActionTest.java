package alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action;

import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.FulfillmentHeightView;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@RunWith(EasyMockRunner.class)
public class UpdateValidityOfFulfillmentHeightsActionTest {

    @Mock
    FulfillmentHeightView fulfillmentHeightView;

    @Test
    public void whenActionTriggered_ThenFulfillmentHeightTextFieldsShouldBeValidated() throws Exception {
        fulfillmentHeightView.validate();
        replay(fulfillmentHeightView);
        UpdateValidityOfFulfillmentHeightsAction updateValidityOfFulfillmentHeightsAction= new
                UpdateValidityOfFulfillmentHeightsAction(fulfillmentHeightView);

        updateValidityOfFulfillmentHeightsAction.valueChange(null);

        verify(fulfillmentHeightView);
    }
}