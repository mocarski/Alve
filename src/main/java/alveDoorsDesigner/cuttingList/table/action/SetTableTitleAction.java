package alveDoorsDesigner.cuttingList.table.action;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.Constants;
import com.vaadin.ui.Label;

public class SetTableTitleAction {

    private final Wardrobe wardrobe;

    public SetTableTitleAction(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    public void execute(Label label) {
        label.setCaption(Constants.prepareTableTitle(wardrobe.getReferenceName()));
    }
}
