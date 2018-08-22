package alveDoorsDesigner.cuttingList.table.action;

import alveDoorsDesigner.cuttingList.table.TableItemProvider;
import alveDoorsDesigner.cuttingList.table.TableOfIntermediates;

public class FillTableAction {

    private final TableItemProvider tableItemProvider;

    public FillTableAction(TableItemProvider tableItemProvider) {
        this.tableItemProvider = tableItemProvider;
    }

    public void execute(TableOfIntermediates table) {
        table.setItems(tableItemProvider.createWardrobeIntermediates());
    }
}
