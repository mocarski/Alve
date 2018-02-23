package com.jm.ui;

public class Constants
{
    //Doors form
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
    public static final String WHITE = "White";
    public static final String SILVER = "Silver";


    //List of components view
    public static final String ITEM_CODE = "Item Code";
    public static final String NAME = "Name";
    public static final String DIMENTION = "Dimension (mm)";
    public static final String QUANTITY = "Quantity";
    public static final String BACK_TO_DOOR_DESIGNING = "Back to door designing";
    public static final String PRINT_PRODUCTION_LIST = "Print production list";
    public static final String DOWNLOAD_PRODUCTION_LIST = "Download production list";
    public static final String CUTTING_LIST = "Cutting list (ref.";

    //List of products
    public static final String ALUMINIUM_DOUBLE_BOTTOM_TRACK = "Aluminium Double Bottom Track";
    public static final String ALUMINIUM_TRACK_COVER = "Aluminium Track Cover";
    public static final String HORIZONTAL_PROFILE_TOP_BOTTOM = "Horizontal Profile Top/Bottom";
    public static final String RIGID_BAR_TT_4_MM_FILLINGS = "Rigid Bar TT – 4mm fillings";
    public static final String RIGID_BAR_TT_8_MM_FILLINGS = "Rigid Bar TT – 8mm fillings";
    public static final String BABY_RIGID_BAR_4_MM_FILLINGS = "Baby Rigid Bar – 4mm fillings";
    public static final String BABY_RIGID_BAR_8_MM_FILLINGS = "Baby Rigid Bar – 8mm fillings";
    public static final String DIVIDING_PROFILE_HOOKUP_FITTING = "Dividing Profile Hook-up Fitting";
    public static final String GLASS_4MM = "Safety Backed 4mm Glass";
    public static final String BOARD_8MM = "Board 8mm";
    public static final String BOTTOM_WHEELED_CONNECTOR_RIGHT = "Bottom Wheeled Connector Right";
    public static final String BOTTOM_WHEELED_CONNECTOR_LEFT = "Bottom Wheeled Connector Left";
    public static final String TOP_WHEELED_CONNECTOR_LEFT = "Top Wheeled Connector Left";
    public static final String TOP_WHEELED_CONNECTOR_RIGHT = "Top Wheeled Connector Right";
    public static final String VERTICAL_PROFILE_RIGHT = "Vertical Profile Right";
    public static final String VERTICAL_PROFILE_LEFT = "Vertical Profile Left";
    public static final String STEEL_DOUBLE_TOP_TRACK = "Steel Double Top Track";
    public static final String TOP_TRACK_DOOR_POSITIONER = "Top Track Door Positioner";
    public static final String SOFT_CLOSE_DUMPER = "Soft Close Dumper 25-35kg";
    public static final String SOFT_CLOSE_DUMPER_ACTIVATOR = "Soft Close Dumper Activator";
    public static final String PVC = "PVC Edging (2mm)";
    public static final String PVC_DIMENSION = "300";
    public static final String SILICON_BUFFERING_DROPS = "Silicon Buffering Drops";
    public static final String SELFTAPPING_WOOD_SCREW = "Selftapping Wood Screw";
    public static final String _3MM_16MM = "3x16";
    public static final String _3MM_25MM = "3x25";
    public static final String TOP_TRACK_FACIO = "Top Track Facio";
    public static final String VENEERED_SELF_ADHESIVE_TAPE = "Veneered Self-Adhesive Tape";
    public static final String H_BAR = "H Bar";
    public static final String MM = "mm";

    //Item codes
    public static final String TOP_WHEELED_CONNECTOR_RIGHT_ITEM_CODE = "WGP";
    public static final String TOP_WHEELED_CONNECTOR_LEFT_ITEM_CODE = "WGL";
    public static final String BOTTOM_WHEELED_CONNECTOR_RIGHT_ITEM_CODE = "WDP";
    public static final String BOTTOM_WHEELED_CONNECTOR_LEFT_ITEM_CODE = "WDL";

    //Validation
    public static final String REFERENCE_NAME_IS_REQUIRED = "Reference name is required";

    //PDF
    public static final String PDF_EXTENSION = ".pdf";

    //Dimensions
    public static final int VERTICAL_PROFILE_WIDTH = 71;
    public static final int PLACE_FOR_FULFILLMENT = 9;
    public static final int HORIZONTAL_PROFILE_WIDTH = 60;
    public static final int HBAR_WIDTH = 61;
    public static final int PLACE_FOR_TOP_WHEEL = 51;
    public static final int PLACE_FOR_BOTTOM_WHEEL = 146;
    public static final int PLACE_FOR_DIVIDING_PROFILE = 32;
    private static final int PLACE_BETWEEN_FLOOR_AND_DOORS = 17;
    private static final int PLACE_BETWEEN_CEILING_AND_DOORS = 34;
    public static final int SILICONE_BUFFERING_THICKNESS = 1;

    public static final int DOORS_LOWER_THEN_CAVITY = PLACE_BETWEEN_FLOOR_AND_DOORS + PLACE_BETWEEN_CEILING_AND_DOORS;
    public static final int DOORS_NARROWER_THEN_CAVITY = 2 * SILICONE_BUFFERING_THICKNESS;
    public static final int SPACE = 2;
    public static final int PLACE_FOR_TOP_WHEEL_CONFLICTED_WITH_MODULE = PLACE_FOR_TOP_WHEEL - HORIZONTAL_PROFILE_WIDTH;
    public static final int PLACE_FOR_BOTTOM_WHEEL_CONFLICTED_WITH_MODULE = PLACE_FOR_BOTTOM_WHEEL -
            HORIZONTAL_PROFILE_WIDTH;
    public static final int PLACE_FOR_RIGID_BAR_INTRUDING_HBAR = (HBAR_WIDTH - PLACE_FOR_DIVIDING_PROFILE)/2;

    public static String getItemCodeForVerticalProfileLeft(String doorFrameColour) {
        if(doorFrameColour.equals("Light Oak"))
            return "LEV67";
        else if(doorFrameColour.equals("Winchester Oak"))
            return "LEV72";
        else if(doorFrameColour.equals("Syberian Oak"))
            return "LEV79";
        else if(doorFrameColour.equals("Tobacco Walnut"))
            return "LEV04";
        else if(doorFrameColour.equals("Mocca Oak"))
            return "LEV07";
        else //Africa Ebony
            return "LEV08";
    }

    public static String getItemCodeForVerticalProfileRight(String doorFrameColour) {
        if(doorFrameColour.equals("Light Oak"))
            return "REV67";
        else if(doorFrameColour.equals("Winchester Oak"))
            return "REV72";
        else if(doorFrameColour.equals("Syberian Oak"))
            return "REV79";
        else if(doorFrameColour.equals("Tobacco Walnut"))
            return "REV04";
        else if(doorFrameColour.equals("Mocca Oak"))
            return "REV07";
        else //Africa Ebony
            return "REV08";
    }

    public static String getItemCodeForTopTrackFacio(String doorFrameColour) {
        if(doorFrameColour.equals("Light Oak"))
            return "MV67";
        else if(doorFrameColour.equals("Winchester Oak"))
            return "MV72";
        else if(doorFrameColour.equals("Syberian Oak"))
            return "MV79";
        else if(doorFrameColour.equals("Tobacco Walnut"))
            return "MV04";
        else if(doorFrameColour.equals("Mocca Oak"))
            return "MV07";
        else if(doorFrameColour.equals("Africa Ebony"))
            return "MV08";
        else //White
            return "MV00";
    }

    public static String getItemCodeForVeeneredSelfAdhesiveTape(String doorFrameColour) {
        if(doorFrameColour.equals("Light Oak"))
            return "TF67";
        else if(doorFrameColour.equals("Winchester Oak"))
            return "TF72";
        else if(doorFrameColour.equals("Syberian Oak"))
            return "TF79";
        else if(doorFrameColour.equals("Tobacco Walnut"))
            return "TF04";
        else if(doorFrameColour.equals("Mocca Oak"))
            return "TF07";
        else //Africa Ebony"
            return "TF08";
    }

    public static String getItemCodeForHorizontalProfile(String doorFrameColour) {
        if(doorFrameColour.equals("Light Oak"))
            return "PV67";
        else if(doorFrameColour.equals("Winchester Oak"))
            return "PV72";
        else if(doorFrameColour.equals("Syberian Oak"))
            return "PV79";
        else if(doorFrameColour.equals("Tobacco Walnut"))
            return "PV04";
        else if(doorFrameColour.equals("Mocca Oak"))
            return "PV07";
        else //Africa Ebony"
            return "PV08";
    }

    public static String getItemCodeForHBar(String doorFrameColour) {
        if(doorFrameColour.equals("Light Oak"))
            return "HV67";
        else if(doorFrameColour.equals("Winchester Oak"))
            return "HV72";
        else if(doorFrameColour.equals("Syberian Oak"))
            return "HV79";
        else if(doorFrameColour.equals("Tobacco Walnut"))
            return "HV04";
        else if(doorFrameColour.equals("Mocca Oak"))
            return "HV07";
        else //Africa Ebony"
            return "HV08";
    }
}
