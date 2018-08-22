package alveDoorsDesigner.doorsDesigner;

public class Constants {
    public static final String HEIGHT = "Height";
    public static final String WIDTH = "Width";
    public static final String REFERENCE_NAME = "Reference name";
    public static final String DOOR_FRAME_COLOUR = "Door frame colour";
    public static final String DIVIDERS_AMOUNT = "Dividers amount";
    public static final String NUMBER_OF_DOORS = "Number of doors";
    public static final String NUMBER_OF_DIVISIONS = "Number of divisions:";
    public static final String HEIGHT_OF_FILLINGS = "Height of fillings:";
    public static final String HEIGHT_OF_FILLING = "Height of filling";
    public static final String TYPE_OF_FILLINGS = "Type od fillings:";
    public static final String ACCESSORIES = "Accessories:";
    public static final String CAVITY_DIMENTIONS = "Cavity dimentions:";
    public static final String PREVIEW_PRODUCTION_LIST = "Preview production list";
    public static final String BOTTOM_TRUCK_COVER = "Bottom track cover";
    public static final String TOP_TRACK_FACIO = "Top Track Facio";
    public static final String WHITE = "White";
    public static final String SILVER = "Silver";

    public static final String PVC_DIMENSION = "300";
    public static final String _3MM_16MM = "3x16";
    public static final String _3MM_25MM = "3x25";
    public static final String MM = "mm";

    //Validation
    public static final String REFERENCE_NAME_IS_REQUIRED = "Reference name is required";

    public static String prepareMessageWhenHeightOfOtherModulesHasToBeChanged(int targetHeightOfModules) {
        return String.format("Summary height of fillings must be equal to %d. Change heights of rest " +
                "fillings to achieve this goal.", targetHeightOfModules);
    }

    public static String prepareMessageWhenHeightOfModuleHasToBeChanged(int targetHeightOfModules, int
            correctHeightOfModule) {
        return String.format("Summary height of fillings must be equal to %d. Enter %d to achieve this goal.",
                targetHeightOfModules, correctHeightOfModule);
    }
}
