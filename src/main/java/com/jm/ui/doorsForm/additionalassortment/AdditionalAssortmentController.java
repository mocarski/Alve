package com.jm.ui.doorsForm.additionalassortment;


import com.jm.model.Door;
import com.jm.model.Wardrobe;

public class AdditionalAssortmentController {

    private final AdditionalAssortmentView additionalAssortmentView;
    private final Wardrobe wardrobe;
    private final Door door;


    public AdditionalAssortmentController(AdditionalAssortmentView additionalAssortmentView, Wardrobe
            wardrobe, Door door) {
        this.additionalAssortmentView = additionalAssortmentView;
        this.wardrobe = wardrobe;
        this.door = door;

        additionalAssortmentView.updatePositioningOptionState(wardrobe, door);
    }

    public void updatePositioningOptionState() {
        additionalAssortmentView.updatePositioningOptionState(wardrobe, door);
    }
}
