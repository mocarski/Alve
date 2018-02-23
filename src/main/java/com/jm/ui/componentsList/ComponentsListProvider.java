package com.jm.ui.componentsList;


import com.jm.model.Wardrobe;
import com.jm.ui.componentsList.factory.*;
import com.jm.ui.componentsList.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class ComponentsListProvider {


    public List<ListItem> prepareListOfComponents(Wardrobe wardrobe) {
        List<ListItem> items = new ArrayList<>();

        items.addAll(new TopWheeledConnectorsFactory().create(wardrobe));
        items.addAll(new BottomWheeledConnectorsFactory().create(wardrobe));
        items.add(new DividingProfileHookUpFittingFactory().create(wardrobe));
        items.addAll(new VerticalProfilesFactory().create(wardrobe));
        items.add(new HorizontalProfileTopBottomFactory().create(wardrobe));
        items.add(new HBarFactory().create(wardrobe));
        items.add(new AluminiumDoubleBottomTrackFactory().create(wardrobe));
        items.add(new AluminiumBottomTrackCoverFactory().create(wardrobe));
        if(wardrobe.getBottomTrackCover().equals(wardrobe.getDoorFrameColour())) {
            items.add(new VeneeredSelfAdhesiveTapeFactory().create(wardrobe));
        }
        items.add(new SteelDoubleTopTrackFactory().create(wardrobe));
        items.add(new TopTrackFacioFactory().create(wardrobe));
        items.addAll(new RigidBarsFactory().create(wardrobe));
        items.addAll(new SelftappingWoodScrewFactory().create(wardrobe));
        items.addAll(new PositionersAndDumpersFactory().create(wardrobe));
        items.addAll(new BabyRigidBarsFactory().create(wardrobe));
        items.add(new SiliconBufferingDrops().create(wardrobe));
        items.addAll(new BoardsAndGlassesFactory().create(wardrobe));

        return items;
    }
}