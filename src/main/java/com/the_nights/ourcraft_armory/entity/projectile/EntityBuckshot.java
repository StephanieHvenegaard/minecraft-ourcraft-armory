/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_nights.ourcraft_armory.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 *
 * @author Stephanie
 */
public class EntityBuckshot extends AbstractArrowEntity {
    public EntityBuckshot(World world)
    {
        super(EntityType.ARROW, world);
    }

    @Override
    protected ItemStack getArrowStack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}