package alveDoorsDesigner.doorsDesigner.fulfillmentHeight;

import static org.junit.Assert.*;
import alveDoorsDesigner.model.Door;
import org.junit.Test;

public class FulfillmentHeightTextFieldTest {
    @Test
    public void FulfillmentHeightTextFieldIsNotValidWhenEmptyValue(){
        Door door = new Door(1000, 2000);
        FulfillmentHeightTextField fulfillmentHeightTextField = new FulfillmentHeightTextField(door, door
                .getModules().get(0));

        fulfillmentHeightTextField.setValue("");
        assertFalse(fulfillmentHeightTextField.isValid());
    }
}