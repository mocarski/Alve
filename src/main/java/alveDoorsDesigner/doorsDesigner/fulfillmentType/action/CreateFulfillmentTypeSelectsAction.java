package alveDoorsDesigner.doorsDesigner.fulfillmentType.action;


import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentTypeView;
import com.vaadin.data.HasValue;

public class CreateFulfillmentTypeSelectsAction implements HasValue.ValueChangeListener<String>
{
    private final FulfillmentTypeView fulfillmentTypeView;

    public CreateFulfillmentTypeSelectsAction(FulfillmentTypeView fulfillmentTypeView)
    {
        this.fulfillmentTypeView = fulfillmentTypeView;
    }


    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent)
    {
        fulfillmentTypeView.createFulfillmentTypeSelects();
    }
}
