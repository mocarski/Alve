package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.model.WardrobeToolbox;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentType;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class BabyRigidBars8Factory implements ListItemFactory {

    @Override
    public TableItem create(Wardrobe wardrobe) {

        int babyRigidBar8mm = WardrobeToolbox.countNumberOfModulesWithFulfillment(FulfillmentType.BOARD,
                wardrobe) * 3;

        return new TableItem(
                Product.BABY_RIGID_BAR_8_MM_FILLINGS.getItemCode(),
                Product.BABY_RIGID_BAR_8_MM_FILLINGS.getName(),
                "",
                babyRigidBar8mm);

    }
}
