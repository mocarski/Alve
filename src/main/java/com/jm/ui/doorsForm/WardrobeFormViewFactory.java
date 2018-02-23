package com.jm.ui.doorsForm;


import com.jm.model.Wardrobe;
import com.jm.navigator.CalcNavigator;
import com.jm.navigator.action.NavigateToComponentsListAction;
import com.jm.ui.Constants;
import com.jm.ui.doorsForm.action.UpdateVisibilityOfPreviewButton;
import com.jm.ui.doorsForm.additionalassortments.AdditionalAssortmentsView;
import com.jm.ui.doorsForm.additionalassortments.action.CreateAdditionalAssortments;
import com.jm.ui.doorsForm.additionalassortments.action.UpdateAdditionalAssortmentsVisibility;
import com.jm.ui.doorsForm.additionalassortments.action.UpdateColors;
import com.jm.ui.doorsForm.additionalassortments.action.UpdatePositioningOptionsState;
import com.jm.ui.doorsForm.basic.BasicView;
import com.jm.ui.doorsForm.cavitydimention.CavityDimentionsView;
import com.jm.ui.doorsForm.divisions.DivisionsView;
import com.jm.ui.doorsForm.divisions.action.UpdateDivisionsViewVisibility;
import com.jm.ui.doorsForm.divisions.action.UpdateDivisionsView;
import com.jm.ui.doorsForm.fulfillmentHeight.HeightOfFillingsView;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsView;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateHeightOfFillingsViewVisibility;
import com.jm.ui.doorsForm.fulfillmentHeight.action.UpdateValidityOfFillingHeights;
import com.jm.ui.doorsForm.fulfillments.FulfillmentsView;
import com.jm.ui.doorsForm.fulfillments.action.CreateFulfillments;
import com.jm.ui.doorsForm.fulfillments.action.UpdateFulfillmentsVisibility;
import com.jm.ui.doorsForm.visualization.VisualizationView;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualizationVisibility;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualizationWhenCorrectModuleHeights;
import com.jm.ui.doorsForm.visualization.action.UpdateVisualization;
import com.vaadin.ui.Button;

public class WardrobeFormViewFactory {
    public static WardrobeFormView create(CalcNavigator calcNavigator,
                                          Wardrobe wardrobe)
    {
        //Create views
        VisualizationView visualizationView = new VisualizationView(wardrobe);

        BasicView basicView = new BasicView( wardrobe );

        CavityDimentionsView cavityDimentionsView = new CavityDimentionsView(wardrobe);

        DivisionsView divisionsView = new DivisionsView(wardrobe);

        HeightOfFillingsView heightOfFillingsView = new HeightOfFillingsView(wardrobe);

        FulfillmentsView fulfillmentsView = new FulfillmentsView(wardrobe);

        AdditionalAssortmentsView additionalAssortmentsView = new AdditionalAssortmentsView(wardrobe);

        Button previewListButton = new Button(Constants.PREVIEW_PRODUCTION_LIST);
        previewListButton.setStyleName("MarginForButton");
        previewListButton.setEnabled(false);

        //Create actions
        CreateFulfillments createFulfillments = new CreateFulfillments(fulfillmentsView);
        UpdateVisualization updateVisualization = new UpdateVisualization( visualizationView );
        UpdateVisualizationWhenCorrectModuleHeights updateVisualizationWhenCorrectModuleHeights = new UpdateVisualizationWhenCorrectModuleHeights(visualizationView,heightOfFillingsView);
        UpdateVisualizationVisibility updateVisualizationVisibility = new UpdateVisualizationVisibility(cavityDimentionsView, visualizationView, basicView);
        UpdateFulfillmentsVisibility updateFulfillmentsVisibility = new UpdateFulfillmentsVisibility(cavityDimentionsView, fulfillmentsView, basicView);
        UpdateDivisionsViewVisibility updateDivisionsViewVisibility = new UpdateDivisionsViewVisibility(cavityDimentionsView, divisionsView, basicView);
        UpdateHeightOfFillingsView updateHeightOfFillingsView = new UpdateHeightOfFillingsView(heightOfFillingsView);
        UpdateHeightOfFillingsViewVisibility updateHeightOfFillingsViewVisibility = new
                UpdateHeightOfFillingsViewVisibility(heightOfFillingsView, divisionsView);
        UpdateValidityOfFillingHeights updateValidityOfFillingHeights = new UpdateValidityOfFillingHeights(heightOfFillingsView);
        UpdateAdditionalAssortmentsVisibility updateAdditionalAssortmentsVisibility = new UpdateAdditionalAssortmentsVisibility(cavityDimentionsView, additionalAssortmentsView, basicView );
        UpdateVisibilityOfPreviewButton updateVisibilityOfPreviewButton = new
                UpdateVisibilityOfPreviewButton(previewListButton, basicView, cavityDimentionsView,
                divisionsView);
        UpdateColors updateColors = new UpdateColors(additionalAssortmentsView);

        //Set actions
        basicView.setActions(updateVisualizationVisibility, updateDivisionsViewVisibility,
                updateFulfillmentsVisibility, updateAdditionalAssortmentsVisibility,
                updateVisibilityOfPreviewButton, updateColors);

        cavityDimentionsView.addActions(updateVisualization, new UpdateDivisionsView(divisionsView),
                createFulfillments, new CreateAdditionalAssortments( additionalAssortmentsView ),
                new UpdatePositioningOptionsState( additionalAssortmentsView ), updateVisualizationVisibility,
                updateDivisionsViewVisibility, updateFulfillmentsVisibility,
                updateAdditionalAssortmentsVisibility, updateVisibilityOfPreviewButton,
                updateHeightOfFillingsView,
                updateHeightOfFillingsViewVisibility);

        divisionsView.setActions(updateVisibilityOfPreviewButton, createFulfillments,
                updateHeightOfFillingsView, updateVisualization, updateHeightOfFillingsViewVisibility);

        heightOfFillingsView.setActions(updateVisualizationWhenCorrectModuleHeights, updateVisibilityOfPreviewButton, updateValidityOfFillingHeights);

        previewListButton.addClickListener(new NavigateToComponentsListAction(calcNavigator));


        WardrobeFormView wardrobeFormView = new WardrobeFormView(visualizationView, basicView,
                cavityDimentionsView, divisionsView, heightOfFillingsView, fulfillmentsView,
                additionalAssortmentsView, previewListButton);

        return wardrobeFormView;
    }
}
