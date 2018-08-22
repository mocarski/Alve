package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.model.WardrobeToolbox;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentType;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class BabyRigidBars4Factory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {

        int babyRigidBar4mm = WardrobeToolbox.countNumberOfModulesWithFulfillment(FulfillmentType.GLASS,
                wardrobe) * 3;

        return new TableItem(
                Product.BABY_RIGID_BAR_4_MM_FILLINGS.getItemCode(),
                Product.BABY_RIGID_BAR_4_MM_FILLINGS.getName(),
                "",
                babyRigidBar4mm);
    }
}
