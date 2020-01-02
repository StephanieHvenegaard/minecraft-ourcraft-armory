package com.the_nights.ourcraft_armory.item.weapon;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public abstract class ItemMeleeWeapon extends SwordItem {
    public ItemMeleeWeapon(IItemTier itemTier, int attackDamageIn, float attackSpeedIn, Item.Properties props) {
        super(itemTier, 0, -2.6f, props);
    }
}

