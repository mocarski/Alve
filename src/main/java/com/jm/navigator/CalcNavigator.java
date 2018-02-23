package com.jm.navigator;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class CalcNavigator extends Navigator {
    public CalcNavigator(UI ui, SingleComponentContainer container) {
        super(ui, container);
    }

    @Override
    public void addView(String viewName, View view){
        super.addView(viewName, view);
    }

    @Override
    public void navigateTo(String navigationState) {
        super.navigateTo(navigationState);
    }
}
