package com.the_nights.ourcraft_armory.core;

import com.the_nights.ourcraft_armory.item.setlists.armor.ObsidianItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ArmoryGroup
{
    public static final ItemGroup COMBAT = new ArmoryTools();               // creative tap
    public static final ItemGroup TOOLS = new AmoryWeapons();               // creative tap
}
class ArmoryTools extends ItemGroup {

    public ArmoryTools() {
        super("ourcraft_armory_tools");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ObsidianItems.pickaxe);
    }
}

class AmoryWeapons extends ItemGroup {

    public AmoryWeapons() {
        super("ourcraft_armory_weapons");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ObsidianItems.katana);
    }
}


