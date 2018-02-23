package com.jm.navigator.action;


import com.jm.navigator.model.NavigationState;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;

public class NavigateToComponentsListAction implements Button.ClickListener {

    private final Navigator navigator;

    public NavigateToComponentsListAction(Navigator navigator )
    {
        this.navigator = navigator;
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        navigator.navigateTo( NavigationState.Components.toString() );
    }
}
