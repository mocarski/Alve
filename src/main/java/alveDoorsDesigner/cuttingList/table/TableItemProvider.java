package alveDoorsDesigner.cuttingList.table;


import alveDoorsDesigner.model.WardrobeToolbox;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentType;
import alveDoorsDesigner.cuttingList.table.tableItemFactory.*;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.model.TableItem;

import java.util.ArrayList;
import java.util.List;

public class TableItemProvider {

    private final Wardrobe wardrobe;

    public TableItemProvider(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    public List<TableItem> createWardrobeIntermediates() {
        List<TableItem> items = new ArrayList<>();

        items.add(new TopWheeledConnectorsLeftFactory().create(wardrobe));
        items.add(new TopWheeledConnectorsRightFactory().create(wardrobe));
        items.add(new BottomWheeledConnectorLeftFactory().create(wardrobe));
        items.add(new BottomWheeledConnectorRightFactory().create(wardrobe));
        items.add(new DividingProfileHookUpFittingFactory().create(wardrobe));
        items.add(new VerticalProfilesLeftFactory().create(wardrobe));
        items.add(new VerticalProfilesRightFactory().create(wardrobe));
        items.add(new HorizontalProfileTopBottomFactory().create(wardrobe));
        items.add(new HBarFactory().create(wardrobe));
        items.add(new AluminiumDoubleBottomTrackFactory().create(wardrobe));
        items.add(new AluminiumBottomTrackCoverFactory().create(wardrobe));

        if(wardrobe.getBottomTrackCover().equals(wardrobe.getColour()))
            items.add(new VeneeredSelfAdhesiveTapeFactory().create(wardrobe));

        items.add(new SteelDoubleTopTrackFactory().create(wardrobe));
        items.add(new TopTrackFacioFactory().create(wardrobe));
        items.addAll(new RigidBars4Factory().create(wardrobe));
        items.addAll(new RigidBars8Factory().create(wardrobe));
        items.addAll(new SelfTappingWoodScrewFactory().create(wardrobe));

        if(WardrobeToolbox.countNumberOfPositioners(wardrobe) != 0)
            items.add(new PositionersFactory().create(wardrobe));
        if(WardrobeToolbox.countNumberOfDumpers(wardrobe) != 0)
            items.addAll(new DumpersFactory().create(wardrobe));

        if(WardrobeToolbox.countNumberOfModulesWithFulfillment(FulfillmentType.GLASS, wardrobe) != 0)
            items.add(new BabyRigidBars4Factory().create(wardrobe));
        if(WardrobeToolbox.countNumberOfModulesWithFulfillment(FulfillmentType.BOARD, wardrobe) != 0)
            items.add(new BabyRigidBars8Factory().create(wardrobe));

        items.add(new SiliconBufferingDropsFactory().create(wardrobe));
        items.addAll(new GlassesFactory().create(wardrobe));
        items.addAll(new BoardsFactory().create(wardrobe));

        return items;
    }

}