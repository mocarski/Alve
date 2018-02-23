package com.jm.model;


import com.jm.ui.Constants;

public class WardrobeToolbox {

    public static int countSummaryWidthOfSectionsOnTheLeft(Wardrobe wardrobe, Door targetDoor) {
        int summaryWidth = 0;

        for(int i=0;i<wardrobe.getDoors().size();i++){
            Door door = wardrobe.getDoors().get(i);
            if (door.equals(targetDoor))
                break;
            if(i==0)
                summaryWidth += door.getWidth() - Constants.VERTICAL_PROFILE_WIDTH/2;
            else
                summaryWidth += door.getWidth() - Constants.VERTICAL_PROFILE_WIDTH;
        }

        return summaryWidth;
    }


    public static int countSummaryHeightOfModulesOnTheTop(Door targetDoor, Module targetModule) {
        int summaryHeight = 0;

        for(int i=0;i<targetDoor.getModules().size();i++){
            Module module = targetDoor.getModules().get(i);
            if (module.equals(targetModule))
                break;
            if(i==0)
                summaryHeight += module.getHeight() + Constants.HORIZONTAL_PROFILE_WIDTH + Constants
                        .HBAR_WIDTH/2;
            else
                summaryHeight += module.getHeight() + Constants.HBAR_WIDTH;
        }

        return summaryHeight;
    }
    /*  _ _ _
       |m|_|_|
       |_|_|_|
       |_|_|_| */
    public static boolean isTopModuleInLeftSection(Wardrobe wardrobe, Door door, Module module) {
        return isTopModule(door, module) && isLeftSection(wardrobe, door);
    }
    /*  _ _ _
       |_|m|_|
       |_|_|_|
       |_|_|_| */
    public static boolean isTopModuleInMiddleSection(Wardrobe wardrobe, Door door, Module module) {
        return isMiddleSection(wardrobe, door) && isTopModule(door, module);
    }
    /*  _ _ _
       |_|_|m|
       |_|_|_|
       |_|_|_| */
    public static boolean isTopModuleInRightSection(Wardrobe wardrobe, Door door, Module module) {
        return isTopModule(door, module) && isRightSection(wardrobe, door);
    }
    /*  _ _ _
       |_|_|_|
       |_|_|m|
       |_|_|_| */
    public static boolean isMiddleModuleInRightSection(Wardrobe wardrobe, Door door, Module module) {
        return isMiddleModule(door, module) && isRightSection(wardrobe, door);
    }
    /*  _ _ _
       |_|_|_|
       |_|_|_|
       |_|_|m| */
    public static boolean isBottomModuleInRightSection(Wardrobe wardrobe, Door door, Module module) {
        return isBottomModule(door, module) && isRightSection(wardrobe, door);
    }
    /*  _ _ _
       |_|_|_|
       |_|_|_|
       |_|m|_| */
    public static boolean isBottomModuleInMiddleSection(Wardrobe wardrobe, Door door, Module module) {
        return isMiddleSection(wardrobe, door) && isBottomModule(door, module);
    }
    /*  _ _ _
       |_|_|_|
       |_|_|_|
       |m|_|_| */
    public static boolean isBottomModuleInLeftSection(Wardrobe wardrobe, Door door, Module module) {
        return isBottomModule(door, module) && isLeftSection(wardrobe, door);
    }
    /*  _ _ _
       |_|_|_|
       |m|_|_|
       |_|_|_| */
    public static boolean isMiddleModuleInLeftSection(Wardrobe wardrobe, Door door, Module module) {
        return isMiddleModule(door, module) && isLeftSection(wardrobe, door);
    }
    /*  _ _ _
       | |_|_|
       |m|_|_|
       |_|_|_| */
    public static boolean isOnlyModuleInLeftSection(Wardrobe wardrobe, Door door, Module module) {
        return isLeftSection(wardrobe, door) && isSingleModule(door,module);
    }
    /*  _ _ _
       |_| |_|
       |_|m|_|
       |_|_|_| */
    public static boolean isOnlyModuleInMiddleSection(Wardrobe wardrobe, Door door, Module module) {
        return isMiddleSection(wardrobe, door) && isSingleModule(door,module);
    }
    /*  _ _ _
       |_|_| |
       |_|_|m|
       |_|_|_| */
    public static boolean isOnlyModuleInRightSection(Wardrobe wardrobe, Door door, Module module) {
        return isRightSection(wardrobe, door) && isSingleModule(door,module);
    }
    /*  _
       |m|
       |_|
       |_| */
    public static boolean isTopModule(Door door, Module module) {
        return getTopModule(door).equals(module);
    }
    /*  _
       |_|
       |m|
       |_| */
    public static boolean isMiddleModule(Door door, Module module) {
        return !isTopModule(door, module) && !isBottomModule(door, module);
    }
    /*  _
       |_|
       |_|
       |m| */
    public static boolean isBottomModule(Door door, Module module) {
        return getBottomModule(door).equals(module);
    }

    /*  _ _ _
       |s|_|_|
       |s|_|_|
       |s|_|_| */
    public static boolean isLeftSection(Wardrobe wardrobe, Door door) {
        return getLeftSection(wardrobe).equals(door);
    }
    /*  _ _ _
       |_|s|_|
       |_|s|_|
       |_|s|_| */
    private static boolean isMiddleSection(Wardrobe wardrobe, Door door) {
        return !isRightSection(wardrobe, door) && !isLeftSection(wardrobe, door);
    }
    /*  _ _ _
       |_|_|s|
       |_|_|s|
       |_|_|s| */
    public static boolean isRightSection(Wardrobe wardrobe, Door door) {
        return getRightSection(wardrobe).equals(door);
    }
    /*  _ _ _
       |s|_|s|
       |s|_|s|
       |s|_|s| */
    public static boolean isUtmostSection(Wardrobe wardrobe, Door door) {
        if (isLeftSection(wardrobe, door) || isRightSection(wardrobe, door))
            return true;

        return false;
    }
    /*  _ _ _
       |m|m|m|
       |_|_|_|
       |m|m|m| */
    public static boolean isUtmostModule(Door door, Module module) {
        if (isTopModule(door,module) || isBottomModule(door,module))
            return true;

        return false;
    }
    /*  _ _ _
       |     |
       |  s  |
       |_ _ _| */
    public static boolean isOnlySection(Wardrobe wardrobe, Door door) {
        return wardrobe.getDoors().size() == 1 && getLeftSection(wardrobe).equals(door);
    }
    //TODO this situation should not occur
    /*  _ _ _
       |     |
       |  m  |
       |_ _ _| */
    public static boolean isSingleModule(Wardrobe wardrobe, Door door, Module module) {
        return isOnlySection(wardrobe, door) && isSingleModule(door,module);
    }
    /*  _
       | |
       |m|
       |_| */
    public static boolean isSingleModule(Door door, Module module) {
        return hasSingleModule(door) && door.getModules().get(0).equals(module);
    }

    private static Door getLeftSection(Wardrobe wardrobe) {
        return wardrobe.getDoors().get(0);
    }

    private static Door getRightSection(Wardrobe wardrobe) {
        return wardrobe.getDoors().get(wardrobe.getAmountOfDoors() - 1);
    }

    private static Module getTopModule(Door door) {
        return door.getModules().get(0);
    }

    private static Module getBottomModule(Door door) {
        return door.getModules().get(door.getAmountOfModules() - 1);
    }

    private static boolean hasSingleModule(Door door) {
        return door.getModules().size() == 1;
    }

    public static String getColor(Wardrobe wardrobe) {
        return String.format(" %s%s%s", "(", wardrobe.getDoorFrameColour(), ")");
    }

}
