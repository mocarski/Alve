package com.jm.model;

import com.jm.model.enums.DoorFrameColour;
import com.jm.ui.Constants;

import java.util.ArrayList;
import java.util.List;


public class Wardrobe
{
    private int cavityWidth = 0;
    private int cavityHeight = 0;
    private int doorsWidth = 0;
    private int doorsHeight = 0;
    private String referenceName = "";
    private String doorFrameColour = DoorFrameColour.LightOak.getName();
    private String topTrackFacio = "";
    private String bottomTruckCover = "";

    // From left to right
    private List<Door> doors = new ArrayList<>();


    public void setCavityWidth(int cavityWidth)
    {
        this.cavityWidth = cavityWidth;
        this.doorsWidth = cavityWidth - Constants.DOORS_NARROWER_THEN_CAVITY;

        for( Door door : doors)
        {
            door.setWidth(calculateDoorWidth(doors.size()));
        }
    }

    public int getCavityWidth()
    {
        return cavityWidth;
    }

    public int getDoorsWidth()
    {
        return doorsWidth;
    }


    public void setCavityHeight(int cavityHeight) {
        this.cavityHeight = cavityHeight;
        this.doorsHeight = cavityHeight - Constants.DOORS_LOWER_THEN_CAVITY;

        for( Door door : doors)
        {
            door.setHeight(doorsHeight);
        }
    }


    public int getCavityHeight()
    {
        return cavityHeight;
    }

    public int getDoorsHeight()
    {
        return doorsHeight;
    }


    public void setAmountOfDoors(int amountOfDoors )
    {
        doors.clear();

        for( int i = 0; i < amountOfDoors; i++ )
        {
            doors.add( new Door( calculateDoorWidth(amountOfDoors), doorsHeight) );
        }
    }

    public int getAmountOfDoors()
    {
        return doors.size();
    }

    public List<Door> getDoors()
    {
        return doors;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referecneName) {
        this.referenceName = referecneName;
    }

    public String getDoorFrameColour() {
        return doorFrameColour;
    }

    public void setDoorFrameColour(String doorFrameColour) {
        this.doorFrameColour = doorFrameColour;
    }

    public String getTopTrackFacio() {
        return topTrackFacio;
    }

    public void setTopTrackFacio(String topTrackFacio) {
        this.topTrackFacio = topTrackFacio;
    }

    public String getBottomTrackCover() {
        return bottomTruckCover;
    }

    public void setBottomTruckCover(String bottomTruckCover) {
        this.bottomTruckCover = bottomTruckCover;
    }

    private int calculateDoorWidth(int amountOfDoors) {
        return (doorsWidth + (amountOfDoors-1) * Constants.VERTICAL_PROFILE_WIDTH ) / amountOfDoors;
    }
}
