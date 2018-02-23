package com.jm.ui.doorsForm.fulfillmentHeight;

import com.jm.model.Door;
import com.jm.model.Module;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class HeighOfFillingValidator implements Validator<Integer> {

    private final Door door;
    private final Module module;

    public HeighOfFillingValidator(Door door, Module module){
        this.door = door;
        this.module = module;
    }

    @Override
    public ValidationResult apply(Integer integer, ValueContext valueContext) {

        if(integer == countCorrectHeightOfModule()){
            return ValidationResult.ok();
        }

        //Dispite of error validation result model is changed to give
        // possibility to change rest of modules heights
        module.setHeight(integer);

        return ValidationResult.error(prepareErrorMessage());
    }

    private String prepareErrorMessage() {
        if(countCorrectHeightOfModule() <= 0){
            return String.format("%s %d. %s.", "Summary height of fillings must be equal to" ,
                    countTargetSummaryHeightOnModules(),
                    "Change heights of rest fillings to achieve this goal");
        }
        return String.format("%s %d. %s %d %s.", "Summary height of fillings must be equal to" ,
                countTargetSummaryHeightOnModules(), "Enter", countCorrectHeightOfModule(),
                "to achieve this goal");
    }

    private int countCorrectHeightOfModule() {
        int summaryOfRestModules = 0;
        for(Module doorModule : door.getModules()){
            if(!doorModule.equals(module))
                summaryOfRestModules += doorModule.getHeight();
        }

        return countTargetSummaryHeightOnModules() - summaryOfRestModules;
    }

    private int countTargetSummaryHeightOnModules() {
        return door.calculateHeightOfModule(door.getHeight(), door.getAmountOfModules
                ()) * door.getModules().size();
    }
}
