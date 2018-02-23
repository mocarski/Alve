package com.jm.model.enums;


import java.util.ArrayList;
import java.util.List;

public enum DoorFrameColour {
    LightOak("Light Oak"), WinchesterOak("Winchester Oak"),
    SyberianOak("Syberian Oak"), TobaccoWalnut("Tobacco Walnut"),
    MoccaOak("Mocca Oak"), AfricaEbony("Africa Ebony");

    private final String name;

    DoorFrameColour(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getDoorFrameColours()
    {
        List<String> colours = new ArrayList<>();

        for(DoorFrameColour colour : DoorFrameColour.values())
        {
            colours.add(colour.getName());
        }

        return colours;
    }
}

