package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import alveDoorsDesigner.Constants;

public class RigidBarLengthCalculator {

    private ModulePositionDetector modulePositionDetector;

    public RigidBarLengthCalculator(ModulePositionDetector modulePositionDetector) {
        this.modulePositionDetector = modulePositionDetector;
    }

    public int calculate(Door door, Module module) {
        int rigidBarLength;
        if (modulePositionDetector.isSingleModule(door, module)) {
            rigidBarLength = door.getHeight() - Constants.PLACE_FOR_TOP_WHEEL
                    - Constants.PLACE_FOR_BOTTOM_WHEEL - 2 * Constants.SPACE;
        } else if (modulePositionDetector.isTopModule(door, module)) {
            rigidBarLength = module.getHeight() -
                    Constants.PLACE_FOR_TOP_WHEEL_CONFLICTED_WITH_MODULE
                    + Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR - 2 * Constants.SPACE;
        } else if (modulePositionDetector.isBottomModule(door, module)) {
            rigidBarLength = module.getHeight() -
                    Constants.PLACE_FOR_BOTTOM_WHEEL_CONFLICTED_WITH_MODULE
                    + Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR - 2 * Constants.SPACE;
        } else {
            rigidBarLength = module.getHeight() + 2 * Constants.PLACE_FOR_RIGID_BAR_INTRUDING_HBAR;
        }
        return rigidBarLength;
    }
}
