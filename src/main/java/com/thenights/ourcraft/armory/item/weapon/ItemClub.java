package com.the_nights.ourcraft_core.core.item.weapon;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ItemClub extends BaseMeleeWeapon {
    public ItemClub(IItemTier itemTier, Item.Properties props) {
        super(itemTier, -2, -3.6f, props);
    }
}
