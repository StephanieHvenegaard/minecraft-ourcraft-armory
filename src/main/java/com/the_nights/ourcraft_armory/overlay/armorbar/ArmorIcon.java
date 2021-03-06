package com.the_nights.ourcraft_armory.overlay.armorbar;

/*
    Class wraps the information required to draw an individual armor icon
 */
public class ArmorIcon
{
    public Type armorIconType;

    /*
        Type = FULL, Type = NONE:
            The color of the icon1
        Type = HALF:
            The color of the left hand side of the icon

     */
    public ArmorIconColor primaryArmorIconColor;
    /*
        Type = HALF:
            The color of the right hand side of the icon
     */
    public ArmorIconColor secondaryArmorIconColor;


    public ArmorIcon()
    {
        armorIconType = Type.NONE;
        primaryArmorIconColor = new ArmorIconColor();
        secondaryArmorIconColor = new ArmorIconColor();
    }

    /*
        The type of armor icon to show.
     */
    public enum Type
    {
        NONE,
        HALF,
        FULL
    }
}
