/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_nights.ourcraft_armory.item;

import com.the_nights.ourcraft_armory.core.OurcraftArmory;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

/**
 * @author Stephanie
 */
public class ItemTagsArmory {
    public static final Tag<Item> FLINTLOCK_AMMO = makeWrapperTag("flintlock_ammo");
    public static final Tag<Item> BLUNDERBUSS_AMMO = makeWrapperTag("blunderbuss_ammo");

    private static Tag<Item> makeWrapperTag(String stack) {
        return new net.minecraft.tags.ItemTags.Wrapper(new ResourceLocation(OurcraftArmory.MODID, stack));
    }
}
