package alveDoorsDesigner.doorsDesigner.fulfillmentType;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FulfillmentTypeViewTest {
    private Wardrobe wardrobe = new Wardrobe();
    private int numberOfDoors = 2;
    private int numberOfModules = 3;

    @Before
    public void setUp() throws Exception {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(numberOfDoors);
        for (Door door : wardrobe.getDoors()) {
            door.setAmountOfModules(numberOfModules);
        }
    }

    @Test
    public void fulfillmentTypeSelectShouldBeCreatedForEveryModuleInWardrobe() {
        HorizontalLayout fulfillmentSelectsForAllDoorsLayout = new HorizontalLayout();
        FulfillmentTypeView fulfillmentTypeView = new FulfillmentTypeView(wardrobe,
                fulfillmentSelectsForAllDoorsLayout);

        fulfillmentTypeView.createFulfillmentTypeSelects();

        assertEquals(6, getAllHeightOfFillingsTextFields(fulfillmentSelectsForAllDoorsLayout).size());
    }

    @Test
    public void
    whenFulfillmentTypeSelectsCreatedAgain_ThenEveryModuleShouldHaveOneCorrespondingFulfillmentTypeSelect() {
        HorizontalLayout fulfillmentSelectsForAllDoorsLayout = new HorizontalLayout();
        FulfillmentTypeView fulfillmentTypeView = new FulfillmentTypeView(wardrobe,
                fulfillmentSelectsForAllDoorsLayout);

        fulfillmentTypeView.createFulfillmentTypeSelects();
        wardrobe.setNumberOfDoors(3);
        for (Door door : wardrobe.getDoors()) {
            door.setAmountOfModules(4);
        }

        fulfillmentTypeView.createFulfillmentTypeSelects();
        assertEquals(12, getAllHeightOfFillingsTextFields(fulfillmentSelectsForAllDoorsLayout).size());
    }

    private List<FulfillmentTypeSelect> getAllHeightOfFillingsTextFields(HorizontalLayout
                                                                                 fulfillmentSelectsForAllDoorsLayout) {
        List<FulfillmentTypeSelect> fulfillmentTypeSelects = new LinkedList<>();
        for (Component verticalLayouts : (Iterable<Component>) () -> fulfillmentSelectsForAllDoorsLayout
                .getComponentIterator
                ()) {
            for (Component fulfillmentTypeSelect : (Iterable<Component>) () -> ((VerticalLayout)
                    verticalLayouts)
                    .getComponentIterator())
                fulfillmentTypeSelects.add((FulfillmentTypeSelect) fulfillmentTypeSelect);
        }

        return fulfillmentTypeSelects;
    }
}