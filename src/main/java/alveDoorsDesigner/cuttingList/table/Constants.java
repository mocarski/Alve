package alveDoorsDesigner.cuttingList.table;

public class Constants {
    public static final String ITEM_CODE = "Item Code";
    public static final String NAME = "Name";
    public static final String DIMENTION = "Dimension (mm)";
    public static final String QUANTITY = "Quantity";

    public static String prepareTableTitle(String referenceName){
        return String.format("%s %s%s", "Cutting list (ref.", referenceName, ")");
    }
}
