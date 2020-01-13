/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_nights.ourcraft_armory.item.weapon.melee;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

import java.util.UUID;

/**
 *
 * @author Stephanie
 */
public class ItemKatana extends SwordItem {

    protected static final UUID ATTACK_REACH_MODIFIER = UUID.fromString("26cb07a3-209d-4110-8e10-1010243614c8");
    protected static final UUID ATTACK_KNOCKBACK_MODIFIER = UUID.fromString("26cb07a3-209d-4110-8e10-1010243614c8");
    private final float attackReach;
    private final float attackKnockBack;
    public ItemKatana(IItemTier itemTier, Item.Properties props) {
        super(itemTier, 1, -1.6f, props);
        this.attackReach =-2;
        this.attackKnockBack =-2;
    }
}
