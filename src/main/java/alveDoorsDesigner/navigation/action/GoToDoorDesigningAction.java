package alveDoorsDesigner.navigation.action;


import alveDoorsDesigner.navigation.NavigationState;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;

public class GoToDoorDesigningAction implements Button.ClickListener {

    public final Navigator navigator;

    public GoToDoorDesigningAction(Navigator navigator)
    {
        this.navigator = navigator;
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        navigator.navigateTo(NavigationState.Wardrobe.toString());
    }

    public void add(Button button){
        button.addClickListener(this);
    }
}
