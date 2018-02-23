package com.jm.ui.doorsForm.action;

import com.jm.ui.doorsForm.basic.BasicView;
import com.jm.ui.doorsForm.cavitydimention.CavityDimentionsView;
import com.jm.ui.doorsForm.divisions.DivisionsView;
import com.vaadin.data.HasValue;
import com.vaadin.ui.Button;

public class UpdateVisibilityOfPreviewButton implements HasValue.ValueChangeListener<String>{

    private final Button previewListButton;
    private final BasicView basicView;
    private final CavityDimentionsView cavityDimentionsView;
    private final DivisionsView divisionsView;

    public UpdateVisibilityOfPreviewButton(Button previewListButton, BasicView basicView, CavityDimentionsView
            cavityDimentionsView, DivisionsView divisionsView){
        this.previewListButton = previewListButton;
        this.basicView = basicView;
        this.cavityDimentionsView = cavityDimentionsView;
        this.divisionsView = divisionsView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        if(basicView.isReferenceNameValid() && cavityDimentionsView.isValid() && divisionsView.isValid()){
            previewListButton.setEnabled(true);
        }
        else{
            previewListButton.setEnabled(false);
        }
    }
}
