package alveDoorsDesigner.doorsDesigner.cavityDimention;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateFulfillmentHeightTextFieldsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import com.google.common.base.Strings;
import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.ui.TextField;

public class CavityHeight extends TextField {

    public CavityHeight(Wardrobe wardrobe) {
        setCaption(Constants.HEIGHT);
        setPlaceholder(Constants.MM);
        setRequiredIndicatorVisible(false);
        setWidth("10%");

        // The only way to achieve proper UI behaviour when TextField is binded with int variable and
        // placeholder at the beginning should be shown.
        addValueChangeListener(getHeightValueChangeListener(wardrobe));
    }

    public boolean isValid() {
        return binder.isValid() && !Strings.isNullOrEmpty(getValue());
    }

    private void bind(Wardrobe wardrobe) {
        binder.forField(this)
                .asRequired("Heigh is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(hight -> hight <= 2800, "Height can not be grater than 2,8 meters")
                .bind(Wardrobe::getCavityHeight, Wardrobe::setCavityHeight);

        binder.setBean(wardrobe);
    }

    public void setActions(UpdateVisibility updateVisibility, UpdateVisualization updateVisualization,
                           UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction) {
        this.updateVisibility = updateVisibility;
        this.updateVisualization = updateVisualization;
        this.updateFulfillmentHeightTextFieldsAction = updateFulfillmentHeightTextFieldsAction;
    }

    private HasValue.ValueChangeListener<String> getHeightValueChangeListener(Wardrobe wardrobe) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                    isBinded = true;
                    bind(wardrobe);
                    addValueChangeListener(updateFulfillmentHeightTextFieldsAction);
                    addValueChangeListener(updateVisualization);
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

    private Binder<Wardrobe> binder = new Binder<>();
    private UpdateVisibility updateVisibility;
    private UpdateVisualization updateVisualization;
    private UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction;
}
