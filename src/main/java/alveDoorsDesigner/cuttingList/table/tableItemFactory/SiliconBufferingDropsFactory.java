package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class SiliconBufferingDropsFactory implements ListItemFactory {
    @Override
    public TableItem create(Wardrobe wardrobe) {
        return new TableItem(
                Product.SILICON_BUFFERING_DROPS.getItemCode(),
                Product.SILICON_BUFFERING_DROPS.getName(),
                "",
                wardrobe.getDoors().size() * 10);
    }
}
