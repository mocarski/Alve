package alveDoorsDesigner.doorsDesigner.cavityDimention;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.doorsDesigner.positioning.action.CreatePositioningOptionsAction;
import alveDoorsDesigner.doorsDesigner.numberOfDivisions.action.CreateNumberOfDivisionFieldsAction;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import com.google.common.base.Strings;
import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.ui.TextField;


public class NumberOfDoors extends TextField {

    private Binder<Wardrobe> binder = new Binder<>();

    private UpdateVisibility updateVisibility;
    private UpdateVisualization updateVisualization;
    private CreateNumberOfDivisionFieldsAction createNumberOfDivisionFieldsAction;
    private CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction;
    private CreatePositioningOptionsAction createPositioningOptionsAction;

    public NumberOfDoors(Wardrobe wardrobe) {
        setCaption(Constants.NUMBER_OF_DOORS);
        setPlaceholder(Constants.NUMBER_OF_DOORS);
        setWidth("10%");

        addValueChangeListener(getNumberOfDoorsValueChangeListener(wardrobe));
    }

    public boolean isValid() {
        return binder.isValid() && !Strings.isNullOrEmpty(this.getValue());
    }

    public void setActions(UpdateVisibility updateVisibility, UpdateVisualization updateVisualization,
                           CreateNumberOfDivisionFieldsAction
                                   createNumberOfDivisionFieldsAction, CreateFulfillmentTypeSelectsAction
                                   createFulfillmentTypeSelectsAction, CreatePositioningOptionsAction
                                   createPositioningOptionsAction) {
        this.updateVisibility = updateVisibility;
        this.updateVisualization = updateVisualization;
        this.createNumberOfDivisionFieldsAction = createNumberOfDivisionFieldsAction;
        this.createFulfillmentTypeSelectsAction = createFulfillmentTypeSelectsAction;
        this.createPositioningOptionsAction = createPositioningOptionsAction;

    }

    private HasValue.ValueChangeListener<String> getNumberOfDoorsValueChangeListener(Wardrobe wardrobe) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                    isBinded = true;
                    bind(wardrobe);
                    addValueChangeListener(updateVisualization);
                    addValueChangeListener(createNumberOfDivisionFieldsAction);
                    addValueChangeListener(createFulfillmentTypeSelectsAction);
                    addValueChangeListener(createPositioningOptionsAction);
                    addValueChangeListener(updateVisibility);
                    setValue(valueChangeEvent.getValue().toString());
                }

                //TextField loses focus when value change from not empty to empty. Line below is the solution.
                if (Strings.isNullOrEmpty((String) valueChangeEvent.getValue())) {
                    ((TextField) valueChangeEvent.getComponent()).focus();
                }
            }
        };
    }

    private void bind(Wardrobe wardrobe) {
        binder.forField(this)
                .asRequired("Number of doors is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(amountOfSections -> amountOfSections <= 7, "Max sections amount is 7")
                .bind(Wardrobe::getAmountOfDoors, Wardrobe::setNumberOfDoors);

        binder.setBean(wardrobe);
    }
}
