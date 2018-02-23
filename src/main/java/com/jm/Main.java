package com.jm;

import javax.servlet.annotation.WebServlet;

import com.jm.model.Wardrobe;
import com.jm.navigator.CalcNavigator;
import com.jm.navigator.model.NavigationState;
import com.jm.ui.componentsList.ComponentsListView;
import com.jm.ui.doorsForm.WardrobeFormView;
import com.jm.ui.doorsForm.WardrobeFormViewFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;


@Theme("mytheme")
public class Main extends com.vaadin.ui.UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Wardrobe wardrobe = new Wardrobe();

        CalcNavigator calcNavigator = new CalcNavigator(this, this);

        ComponentsListView componentsListView = ComponentsListView.create(calcNavigator, wardrobe);
        WardrobeFormView wardrobeFormView = WardrobeFormViewFactory.create(calcNavigator, wardrobe);

        calcNavigator.addView(NavigationState.Wardrobe.toString(), wardrobeFormView);
        calcNavigator.addView(NavigationState.Components.toString(), componentsListView);
        calcNavigator.navigateTo(NavigationState.Wardrobe.toString());

//        addButtonToBindingCheck(wardrobeFormView, wardrobe );

        setContent(wardrobeFormView);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Main.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    private void addButtonToBindingCheck(WardrobeFormView wardrobeView, Wardrobe wardrobe )
    {
        Button button = new Button( "Check" );
        button.addClickListener(createListenerToShowWardrobeObjectDetails(wardrobe));
        wardrobeView.addComponent( button );
        wardrobeView.setComponentAlignment( button, Alignment.MIDDLE_CENTER);
    }


    private static Button.ClickListener createListenerToShowWardrobeObjectDetails( Wardrobe wardrobe )
    {
        return event -> Notification
                .show(
                        "Reference Name" + wardrobe.getReferenceName() + System.lineSeparator() +
                                "Colour" + wardrobe.getDoorFrameColour() + System.lineSeparator() +
                                "Width " + wardrobe.getCavityWidth() +
                                " High" + wardrobe.getCavityHeight());
    }
}
