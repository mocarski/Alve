package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

public class TopTrackFacioFactory implements ListItemFactory {

    @Override
    public TableItem create(Wardrobe wardrobe) {
        Product topTrackFacio = Product.getTopTrackFacio(wardrobe.getTopTrackFacio());
        return new TableItem(
                topTrackFacio.getItemCode(),
                topTrackFacio.getName(),
                Integer.toString(wardrobe.getCavityWidth()),
                1);
    }
}
