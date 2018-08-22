package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class DividingProfileHookUpFittingFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.DIVIDING_PROFILE_HOOKUP_FITTING.getItemCode(),
                Product.DIVIDING_PROFILE_HOOKUP_FITTING.getName(),
                "",
                countNumberOfDividingProfiles(wardrobe));
    }

    private int countNumberOfDividingProfiles(Wardrobe wardrobe) {
        int numberOfDividingProfiles = 0;
        for (Door door : wardrobe.getDoors()) {
            numberOfDividingProfiles += 2 * door.getNumberOfDivisions();
        }

        return numberOfDividingProfiles;
    }
}
