package alveDoorsDesigner.cuttingList;

import alveDoorsDesigner.navigation.action.GoToDoorDesigningAction;
import com.vaadin.ui.Button;

public class BackToDoorDesigningButton extends Button {

    public BackToDoorDesigningButton(GoToDoorDesigningAction goToDoorDesigningAction) {
        setCaption(Constants.BACK_TO_DOOR_DESIGNING);
        goToDoorDesigningAction.add(this);
    }
}
