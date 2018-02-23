package com.jm.ui.componentsList;


import com.jm.model.Wardrobe;
import com.jm.navigator.CalcNavigator;
import com.jm.navigator.action.NavigateToDoorsFormAction;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.action.DownloadPdfAction;
import com.jm.ui.componentsList.action.OpenPdfAction;
import com.jm.ui.componentsList.model.ListItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.List;

public class ComponentsListView extends VerticalLayout implements View {

    private Grid<ListItem> grid = new Grid<>();
    private Label label = new Label();
    private Wardrobe wardrobe;
    private Button print = new Button(Constants.PRINT_PRODUCTION_LIST);
    private Button back = new Button(Constants.BACK_TO_DOOR_DESIGNING);
    private Button download = new Button(Constants.DOWNLOAD_PRODUCTION_LIST);
    private OpenPdfAction openPdfAction = new OpenPdfAction();
    private DownloadPdfAction downloadPdfAction = new DownloadPdfAction();


    public ComponentsListView(NavigateToDoorsFormAction navigateToDoorsFormAction, Wardrobe wardrobe)
    {
        this.wardrobe = wardrobe;

        HorizontalLayout gridTitleLayout = new HorizontalLayout();
        gridTitleLayout.addComponent(label);
        gridTitleLayout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

        grid.addColumn( ListItem::getItemCode).setCaption(Constants.ITEM_CODE);
        grid.addColumn( ListItem::getName).setCaption(Constants.NAME);
        grid.addColumn( ListItem::getDimention).setCaption(Constants.DIMENTION);
        grid.addColumn( ListItem::getQuantity).setCaption(Constants.QUANTITY);
        grid.setWidth("700px");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        back.addClickListener(navigateToDoorsFormAction);
        horizontalLayout.addComponents(back, print, download);
        horizontalLayout.setComponentAlignment( back, Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment( print, Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment( download, Alignment.MIDDLE_CENTER);
        horizontalLayout.setHeight( 45 + "px");

        addComponents(gridTitleLayout, grid, horizontalLayout);
        setComponentAlignment( gridTitleLayout, Alignment.TOP_CENTER);
        setComponentAlignment( grid, Alignment.TOP_CENTER);
        setComponentAlignment( horizontalLayout, Alignment.TOP_CENTER);

        setSizeUndefined();
        setWidth("100%");
        setStyleName("MarginTopAndBottom");
    }

    public static ComponentsListView create(CalcNavigator calcNavigator, Wardrobe wardrobe){

        NavigateToDoorsFormAction navigateToDoorsFormAction = new NavigateToDoorsFormAction(calcNavigator);
        ComponentsListView componentsListView = new ComponentsListView(navigateToDoorsFormAction,wardrobe);

        return componentsListView;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        label.setCaption(
                String.format("%s %s%s",Constants.CUTTING_LIST, wardrobe.getReferenceName(),")"));

        List<ListItem> listItems = new ComponentsListProvider().prepareListOfComponents( wardrobe );

        grid.setItems( listItems );
        grid.setHeight( 38+ 38*listItems.size() + "px");

        openPdfAction.assignActionToButton(print, wardrobe);
        downloadPdfAction.assignActionToButton(download, wardrobe);
    }
}
