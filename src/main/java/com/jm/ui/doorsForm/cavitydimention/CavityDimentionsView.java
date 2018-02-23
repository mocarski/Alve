package com.jm.ui.doorsForm.cavitydimention;


import com.google.common.base.Strings;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.action.UpdateVisibilityOfPreviewButton;
import com.jm.ui.doorsForm.additionalassortments.action.UpdateAdditionalAssortmentsVisibility;
import com.jm.ui.doorsForm.additionalassortments.action.CreateAdditionalAssortments;
import com.jm.ui.doorsForm.additionalassortments.action.UpdatePositioningOptionsState;
import com.jm.ui.doorsForm.divisions.action.UpdateDivisionsViewVisibility;
import com.jm.ui.doorsForm.divisions.action.UpdateDivisionsView;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsView;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsViewVisibility;
import com.jm.ui.doorsForm.fulfillments.action.UpdateFulfillmentsVisibility;
import com.jm.ui.doorsForm.fulfillments.action.CreateFulfillments;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualizationVisibility;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualization;
import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.ui.*;

public class CavityDimentionsView extends VerticalLayout {

    private TextField heightTextField;
    private TextField widthTextField;
    private TextField numberOfDoorsTextField;

    private Binder<Wardrobe> heightBinder = new Binder<>();
    private Binder<Wardrobe> widthBinder = new Binder<>();
    private Binder<Wardrobe> numberOfDoorsBinder = new Binder<>();

    public CavityDimentionsView(Wardrobe wardrobe)
    {
        heightTextField = createHeighTextField();
        widthTextField = createWidthTextField();
        numberOfDoorsTextField = createNumberOfDoorsTextField();

        FormLayout formLayout = new FormLayout();
        formLayout.setSizeUndefined();
        formLayout.addComponents(heightTextField, widthTextField, numberOfDoorsTextField);

        Label label = new Label(Constants.CAVITY_DIMENTIONS);

        addComponents(label, formLayout);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        // Take minimum space
        setWidthUndefined();
        setStyleName("MarginTop");

        bindViewWithWardrobe(wardrobe);
    }


    private TextField createNumberOfDoorsTextField()
    {
        TextField numberOfDoorsTextField = new TextField();
        numberOfDoorsTextField.setCaption( Constants.NUMBER_OF_DOORS );
        numberOfDoorsTextField.setPlaceholder( Constants.NUMBER_OF_DOORS );
        numberOfDoorsTextField.setWidth( "10%" );
        numberOfDoorsTextField.setRequiredIndicatorVisible(true);

        return numberOfDoorsTextField;
    }


    private TextField createWidthTextField()
    {
        TextField widthTextField = new TextField();
        widthTextField.setCaption( Constants.WIDTH );
        widthTextField.setPlaceholder( Constants.MM );
        widthTextField.setWidth( "10%" );
        widthTextField.setRequiredIndicatorVisible(true);

        return widthTextField;
    }


    private TextField createHeighTextField()
    {
        TextField hightTextField = new TextField();
        hightTextField.setCaption( Constants.HEIGHT);
        hightTextField.setPlaceholder( Constants.MM );
        hightTextField.setWidth( "10%" );
        hightTextField.setRequiredIndicatorVisible(true);

        return hightTextField;
    }


    public void addActions(UpdateVisualization updateVisualization, UpdateDivisionsView
            updateDivisionsView,
                           CreateFulfillments createFulfillments, CreateAdditionalAssortments
                                   createAdditionalAssortments,
                           UpdatePositioningOptionsState updatePositioningOptionsState, UpdateVisualizationVisibility
                                   updateVisualizationVisibility,
                           UpdateDivisionsViewVisibility updateDivisionsViewVisibility,
                           UpdateFulfillmentsVisibility updateFulfillmentsVisibility,
                           UpdateAdditionalAssortmentsVisibility updateAdditionalAssortmentsVisibility,
                           UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton,
                           UpdateHeightOfFillingsView updateHeightOfFillingsView,
                           UpdateHeightOfFillingsViewVisibility updateHeightOfFillingsViewVisibility) {
        this.updateVisualization = updateVisualization;
        this.updateDivisionsView = updateDivisionsView;
        this.createFulfillments = createFulfillments;
        this.createAdditionalAssortments = createAdditionalAssortments;
        this.updatePositioningOptionsState = updatePositioningOptionsState;
        this.updateVisualizationVisibility = updateVisualizationVisibility;
        this.updateDivisionsViewVisibility = updateDivisionsViewVisibility;
        this.updateFulfillmentsVisibility = updateFulfillmentsVisibility;
        this.updateAdditionalAssortmentsVisibility = updateAdditionalAssortmentsVisibility;
        this.updateVisibilityOfPreviewButton = updateVisibilityOfPreviewButton;
        this.updateHeightOfFillingsView = updateHeightOfFillingsView;
        this.updateHeightOfFillingsViewVisibility = updateHeightOfFillingsViewVisibility;

    }

    private void bindViewWithWardrobe(Wardrobe wardrobe) {
        // The only way to achieve proper UI behaviour when TextField is binded with int variable and
        // placeholder at the beginning should be shown.
        heightTextField.addValueChangeListener(getHeightValueChangeListener
                (wardrobe));

        widthTextField.addValueChangeListener(getWidthValueChangeListener
                (wardrobe));
        numberOfDoorsTextField.addValueChangeListener
                (getNumberOfDoorsValueChangeListener
                        (wardrobe));
    }

    private HasValue.ValueChangeListener<String> getHeightValueChangeListener(Wardrobe wardrobe) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                    isBinded = true;
                    createHeightBinder(heightTextField).setBean(wardrobe);
                    heightTextField.addValueChangeListener(updateVisualization);
                    heightTextField.addValueChangeListener(updateVisualizationVisibility);
                    heightTextField.addValueChangeListener(updateDivisionsViewVisibility);
                    heightTextField.addValueChangeListener(updateHeightOfFillingsView);
                    heightTextField.addValueChangeListener(updateFulfillmentsVisibility);
                    heightTextField.addValueChangeListener(updateAdditionalAssortmentsVisibility);
                    heightTextField.addValueChangeListener(updateVisibilityOfPreviewButton);
                    heightTextField.setValue(valueChangeEvent.getValue().toString());
                }

                //TextField loses focus when value change from not empty to empty. Line below is the solution.
                if (Strings.isNullOrEmpty((String)valueChangeEvent.getValue())) {
                    ((TextField)valueChangeEvent.getComponent()).focus();
                }
            }
        };
    }

    private HasValue.ValueChangeListener<String> getWidthValueChangeListener(Wardrobe wardrobe) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                    isBinded = true;
                    createWidthBinder(widthTextField).setBean(wardrobe);
                    widthTextField.addValueChangeListener(updateVisualization);
                    widthTextField.addValueChangeListener(updatePositioningOptionsState);
                    widthTextField.addValueChangeListener(updateVisualizationVisibility);
                    widthTextField.addValueChangeListener(updateDivisionsViewVisibility);
                    widthTextField.addValueChangeListener(updateFulfillmentsVisibility);
                    widthTextField.addValueChangeListener(updateAdditionalAssortmentsVisibility);
                    widthTextField.addValueChangeListener(updateVisibilityOfPreviewButton);
                    widthTextField.setValue(valueChangeEvent.getValue().toString());
                }

                //TextField loses focus when value change from not empty to empty. Line below is the solution.
                if (Strings.isNullOrEmpty((String)valueChangeEvent.getValue())) {
                    ((TextField)valueChangeEvent.getComponent()).focus();
                }
            }
        };
    }

    private HasValue.ValueChangeListener<String> getNumberOfDoorsValueChangeListener(Wardrobe wardrobe) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                    isBinded = true;
                    createAmoutOfSectionsBinder(numberOfDoorsTextField).setBean
                            (wardrobe);
                    numberOfDoorsTextField.addValueChangeListener(updateVisualization);
                    numberOfDoorsTextField.addValueChangeListener(updateDivisionsView);
                    numberOfDoorsTextField.addValueChangeListener(createFulfillments);
                    numberOfDoorsTextField.addValueChangeListener(createAdditionalAssortments);
                    numberOfDoorsTextField.addValueChangeListener(updatePositioningOptionsState);
                    numberOfDoorsTextField.addValueChangeListener(updateVisualizationVisibility);
                    numberOfDoorsTextField.addValueChangeListener(updateDivisionsViewVisibility);
                    numberOfDoorsTextField.addValueChangeListener(updateHeightOfFillingsViewVisibility);
                    numberOfDoorsTextField.addValueChangeListener(updateFulfillmentsVisibility);
                    numberOfDoorsTextField.addValueChangeListener(updateAdditionalAssortmentsVisibility);
                    numberOfDoorsTextField.addValueChangeListener(updateVisibilityOfPreviewButton);
                    numberOfDoorsTextField.setValue(valueChangeEvent.getValue().toString());
                }

                //TextField loses focus when value change from not empty to empty. Line below is the solution.
                if (Strings.isNullOrEmpty((String)valueChangeEvent.getValue())) {
                    ((TextField)valueChangeEvent.getComponent()).focus();
                }
            }
        };
    }

    private Binder<Wardrobe> createHeightBinder(TextField highTextField) {
        heightBinder.forField(highTextField)
                .asRequired("Heigh is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(hight -> hight <= 2800, "Height can not be grater than 2,8 meters")
                .bind(Wardrobe::getCavityHeight, Wardrobe::setCavityHeight);

        return heightBinder;
    }

    private Binder<Wardrobe> createWidthBinder(TextField widthTextField) {
        widthBinder.forField(widthTextField)
                .asRequired("Width is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(width -> width <= 5000, "Width can not be grater than 5 meters")
                .bind(Wardrobe::getCavityWidth, Wardrobe::setCavityWidth);

        return widthBinder;
    }

    public boolean isCavityDimentionsValid() {

        if (heightBinder.isValid() &&
                !Strings.isNullOrEmpty(heightTextField.getValue()) &&
                widthBinder.isValid() &&
                !Strings.isNullOrEmpty(widthTextField.getValue()) &&
                numberOfDoorsBinder.isValid() &&
                !Strings.isNullOrEmpty(numberOfDoorsTextField.getValue())) {
            return true;
        }

        return false;
    }

    public boolean isValid()
    {
        if(!Strings.isNullOrEmpty(heightTextField.getValue()) && heightBinder.isValid()
                && !Strings.isNullOrEmpty(widthTextField.getValue()) && widthBinder.isValid() &&
                !Strings.isNullOrEmpty(numberOfDoorsTextField.getValue())&& numberOfDoorsBinder.isValid()){
            return true;
        }

        return false;
    }

    private Binder<Wardrobe> createAmoutOfSectionsBinder(TextField amountOfSectionsTextField) {
        numberOfDoorsBinder.forField(amountOfSectionsTextField)
                .asRequired("Number of doors is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(amountOfSections -> amountOfSections <= 7, "Max sections amount is 7")
                .bind(Wardrobe::getAmountOfDoors, Wardrobe::setAmountOfDoors);

        return numberOfDoorsBinder;
    }


    private UpdateVisualization updateVisualization;
    private UpdateDivisionsView updateDivisionsView;
    private CreateFulfillments createFulfillments;
    private CreateAdditionalAssortments createAdditionalAssortments;
    private UpdatePositioningOptionsState updatePositioningOptionsState;
    private UpdateVisualizationVisibility updateVisualizationVisibility;
    private UpdateDivisionsViewVisibility updateDivisionsViewVisibility;
    private UpdateFulfillmentsVisibility updateFulfillmentsVisibility;
    private UpdateAdditionalAssortmentsVisibility updateAdditionalAssortmentsVisibility;
    private UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton;
    private UpdateHeightOfFillingsView updateHeightOfFillingsView;
    private UpdateHeightOfFillingsViewVisibility updateHeightOfFillingsViewVisibility;
}
