package com.jm.navigator.action;


import com.jm.navigator.model.NavigationState;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;

public class NavigateToDoorsFormAction implements Button.ClickListener {

    public final Navigator navigator;

    public NavigateToDoorsFormAction(Navigator navigator)
    {
        this.navigator = navigator;
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        navigator.navigateTo(NavigationState.Wardrobe.toString());
    }
}
