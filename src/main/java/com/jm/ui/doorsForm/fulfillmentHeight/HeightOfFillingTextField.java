package com.jm.ui.doorsForm.fulfillmentHeight;

import com.google.common.base.Strings;
import com.jm.model.Module;
import com.jm.model.Door;
import com.jm.ui.Constants;
import com.vaadin.data.Binder;
import com.vaadin.ui.TextField;

public class HeightOfFillingTextField extends TextField {

    private final Door door;
    private final Module module;

    Binder<Module> binder = new Binder<>();

    public HeightOfFillingTextField(Door door, Module module){
        this.door = door;
        this.module = module;
        setPlaceholder(Constants.HEIGHT_OF_FILLING);
        bindModuleWithDivisionTextField();
    }

    private void bindModuleWithDivisionTextField() {
        binder.forField(this)
                .asRequired("The height of fulfillment is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(divisionValue -> divisionValue <= door.getHeight(),
                        "The value of the fulfillment can not be higher than hight of the wardrobe")
                .withValidator(new HeighOfFillingValidator(door, module))
                .bind(Module::getHeight, Module::setHeight);

        binder.setBean(module);
    }

    public boolean isValid() {
        if(Strings.isNullOrEmpty(getValue()) || !binder.isValid())
                return false;

        return true;
    }

    public void validate() {
        binder.validate();
    }
}
