package alveDoorsDesigner.doorsDesigner.cavityDimention;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.positioning.action.UpdatePositioningOptionsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import com.google.common.base.Strings;
import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.ui.TextField;

public class CavityWidth extends TextField {

    private Binder<Wardrobe> binder = new Binder<>();
    private UpdateVisibility updateVisibility;
    private UpdateVisualization updateVisualization;
    private UpdatePositioningOptionsAction updatePositioningOptionsAction;

    public CavityWidth(Wardrobe wardrobe) {
        setCaption(Constants.WIDTH);
        setPlaceholder(Constants.MM);
        setWidth("10%");

        // The only way to achieve proper UI behaviour when TextField is binded with int variable and
        // placeholder at the beginning should be shown.
        addValueChangeListener(getWidthValueChangeListener(wardrobe));
    }

    public boolean isValid() {
        return binder.isValid() && !Strings.isNullOrEmpty(this.getValue());
    }

    public void setActions(UpdateVisibility updateVisibility, UpdateVisualization updateVisualization,
                           UpdatePositioningOptionsAction updatePositioningOptionsAction) {
        this.updateVisibility = updateVisibility;
        this.updateVisualization = updateVisualization;
        this.updatePositioningOptionsAction = updatePositioningOptionsAction;
    }

    private HasValue.ValueChangeListener<String> getWidthValueChangeListener(Wardrobe wardrobe) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                    isBinded = true;
                    bind(wardrobe);
                    addValueChangeListener(updateVisibility);
                    addValueChangeListener(updateVisualization);
                    addValueChangeListener(updatePositioningOptionsAction);
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
                .asRequired("Width is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(width -> width <= 5000, "Width can not be grater than 5 meters")
                .bind(Wardrobe::getCavityWidth, Wardrobe::setCavityWidth);

        binder.setBean(wardrobe);
    }
}
