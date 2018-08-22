package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.model.WardrobeToolbox;
import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

import java.util.ArrayList;
import java.util.List;

public class DumpersFactory implements ListItemsFactory {
    @Override
    public List<TableItem> create(Wardrobe wardrobe) {

        List<TableItem> items = new ArrayList<>();

        int numberOfDumpers = WardrobeToolbox.countNumberOfDumpers(wardrobe);

        items.add(new TableItem(
                Product.SOFT_CLOSE_DUMPER.getItemCode(),
                Product.SOFT_CLOSE_DUMPER.getName(),
                "",
                numberOfDumpers));

        items.add(new TableItem(
                Product.SOFT_CLOSE_DUMPER_ACTIVATOR.getItemCode(),
                Product.SOFT_CLOSE_DUMPER_ACTIVATOR.getName(),
                "",
                numberOfDumpers));

        items.add(new TableItem(
                Product.PVC.getItemCode(),
                Product.PVC.getName(),
                Constants.PVC_DIMENSION,
                numberOfDumpers * 2));

        return items;
    }
}
