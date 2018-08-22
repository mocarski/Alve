package alveDoorsDesigner.doorsDesigner.cavityDimention;

import com.vaadin.ui.*;

public class CavityDimentionView extends VerticalLayout {

    public CavityDimentionView(Label headline, FormLayout formLayout, CavityHeight cavityHeight, CavityWidth cavityWidth,
                               NumberOfDoors numberOfDoors) {
        this.cavityHeight = cavityHeight;
        this.cavityWidth = cavityWidth;
        this.numberOfDoors = numberOfDoors;

        formLayout.addComponents(cavityHeight, cavityWidth, numberOfDoors);

        addComponents(headline, formLayout);
        setComponentAlignment(headline, Alignment.MIDDLE_CENTER);

        setWidthUndefined();
        setMargin(false);
        setStyleName("MarginTopAndBottom");
    }

    public boolean isValid() {
        return cavityHeight.isValid() && cavityWidth.isValid() && numberOfDoors.isValid();
    }

    private final CavityHeight cavityHeight;
    private final CavityWidth cavityWidth;
    private final NumberOfDoors numberOfDoors;
}
