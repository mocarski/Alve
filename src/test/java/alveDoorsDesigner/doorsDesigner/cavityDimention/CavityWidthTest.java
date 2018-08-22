package alveDoorsDesigner.doorsDesigner.cavityDimention;

import alveDoorsDesigner.doorsDesigner.positioning.action.UpdatePositioningOptionsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import alveDoorsDesigner.model.Wardrobe;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(EasyMockRunner.class)
public class CavityWidthTest {
    @Mock
    UpdateVisibility updateVisibility;

    @Mock
    UpdateVisualization updateVisualization;

    @Mock
    UpdatePositioningOptionsAction updatePositioningOptionsAction;

    private CavityWidth cavityWidth;

    @Before
    public void setUp() throws Exception {
        cavityWidth = new CavityWidth(new Wardrobe());
        cavityWidth.setActions(updateVisibility, updateVisualization,
                updatePositioningOptionsAction);
    }

    @Test
    public void cavityWidthIsNotValidWhenEmptyValue() {
        cavityWidth.setValue("");
        assertFalse(cavityWidth.isValid());
    }

    @Test
    public void cavityCanNotBeWiderThen5000mm() {
        cavityWidth.setValue("5000");
        assertTrue(cavityWidth.isValid());

        cavityWidth.setValue("5001");
        assertFalse(cavityWidth.isValid());
    }

    @Test
    public void afterValueChange_VisualizationShouldBeUpdated() {
        updateVisualization.valueChange(anyObject());
        replay(updateVisualization);

        cavityWidth.setValue("anyValue");
        verify(updateVisualization);
    }

    @Test
    public void afterValueChange_PositioningOptionsShouldBeUpdated() {
        updatePositioningOptionsAction.valueChange(anyObject());
        replay(updatePositioningOptionsAction);

        cavityWidth.setValue("anyValue");
        verify(updatePositioningOptionsAction);
    }

    @Test
    public void afterValueChange_VisibilityOfDesignerSectionsShouldBeUpdated() {
        updateVisibility.valueChange(anyObject());
        replay(updateVisibility);

        cavityWidth.setValue("anyValue");
        verify(updateVisibility);
    }
}