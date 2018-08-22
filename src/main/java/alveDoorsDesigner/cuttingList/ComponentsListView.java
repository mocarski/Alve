package alveDoorsDesigner.cuttingList;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.TableItemProvider;
import alveDoorsDesigner.cuttingList.table.TableOfIntermediates;
import alveDoorsDesigner.cuttingList.table.action.FillTableAction;
import alveDoorsDesigner.cuttingList.table.action.SetTableTitleAction;
import alveDoorsDesigner.navigation.action.GoToDoorDesigningAction;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

public class ComponentsListView extends VerticalLayout implements View {

    private Label tableTitle = new Label();
    private TableOfIntermediates table = TableOfIntermediates.create();
    private final PrintButton printButton;
    private final DownloadButton downloadButton;
    private final SetTableTitleAction setTableTitleAction;
    private final FillTableAction fillTableAction;


    public ComponentsListView(SetTableTitleAction setTableTitleAction, FillTableAction fillTableAction,
                              BackToDoorDesigningButton backButton, PrintButton printButton, DownloadButton
                                      downloadButton) {
        this.setTableTitleAction = setTableTitleAction;
        this.fillTableAction = fillTableAction;
        this.printButton = printButton;
        this.downloadButton = downloadButton;

        HorizontalLayout tableTitleLayout = createTableTitleLayout(tableTitle);
        HorizontalLayout buttonsLayout = createButtonsLayout(backButton, downloadButton, printButton);
        addComponents(tableTitleLayout, table, buttonsLayout);
        setComponentAlignment(tableTitleLayout, Alignment.MIDDLE_CENTER);
        setComponentAlignment(table, Alignment.MIDDLE_CENTER);
        setComponentAlignment(buttonsLayout, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        setTableTitleAction.execute(tableTitle);
        fillTableAction.execute(table);
        printButton.updatePDFToPrint();
        downloadButton.updatePDFToDownload();
    }

    public static ComponentsListView create(Navigator navigator, Wardrobe wardrobe) {
        SetTableTitleAction setTableTitleAction = new SetTableTitleAction(wardrobe);
        FillTableAction fillTableAction = new FillTableAction(new TableItemProvider(wardrobe));
        GoToDoorDesigningAction goToDoorDesigningAction = new GoToDoorDesigningAction(navigator);
        BackToDoorDesigningButton backButton = new BackToDoorDesigningButton(goToDoorDesigningAction);
        DownloadButton downloadButton = new DownloadButton(wardrobe);
        PrintButton printButton = new PrintButton(wardrobe);

        ComponentsListView componentsListView = new ComponentsListView(setTableTitleAction,
                fillTableAction, backButton, printButton, downloadButton);

        return componentsListView;
    }

    /*Layout for table title is created only because of wrong label rendering without layout.
    * Label is too height as a result of which space beetwen label and table is to big.*/
    private static HorizontalLayout createTableTitleLayout(Label tableTitle) {
        HorizontalLayout tableTitleLayout = new HorizontalLayout();
        tableTitleLayout.addComponent(tableTitle);
        tableTitleLayout.setComponentAlignment(tableTitle, Alignment.MIDDLE_CENTER);
        return tableTitleLayout;
    }

    private HorizontalLayout createButtonsLayout(Button back, Button download, Button print) {
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.addComponents(back, print, download);
        buttonsLayout.setComponentAlignment(back, Alignment.MIDDLE_LEFT);
        buttonsLayout.setComponentAlignment(print, Alignment.MIDDLE_CENTER);
        buttonsLayout.setComponentAlignment(download, Alignment.MIDDLE_RIGHT);
        buttonsLayout.setWidth(70, Unit.PERCENTAGE);
        return buttonsLayout;
    }
}
