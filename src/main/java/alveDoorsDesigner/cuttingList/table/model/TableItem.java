package alveDoorsDesigner.cuttingList.table.model;


public class TableItem {

    private final String itemCode;
    private final String name;
    private final String dimention;
    private final int quantity;

    public TableItem(String itemCode, String name, String dimention, int quantity)
    {
        this.itemCode = itemCode;
        this.name = name;
        this.dimention = dimention;
        this.quantity = quantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }

    public String getDimention() {
        return dimention;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableItem tableItem = (TableItem) o;

        if (quantity != tableItem.quantity) return false;
        if (itemCode != null ? !itemCode.equals(tableItem.itemCode) : tableItem.itemCode != null) return false;
        if (!name.equals(tableItem.name)) return false;
        return dimention != null ? dimention.equals(tableItem.dimention) : tableItem.dimention == null;
    }

    @Override
    public int hashCode() {
        int result = itemCode != null ? itemCode.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (dimention != null ? dimention.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}
