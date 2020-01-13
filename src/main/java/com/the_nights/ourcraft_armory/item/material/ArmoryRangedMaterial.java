/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_nights.ourcraft_armory.item.material;

/**
 *
 * @author Stephanie
 */
public enum ArmoryRangedMaterial {

    FLINTLOCK_MUSKET(ArmoryProjectileMaterial.FLINT_LOCK_MUSKET_AMMO, 1, 5.0f, 2.3f, 80,5,  30,false),
    FLINTLOCK_BLUNDERBUSS(ArmoryProjectileMaterial.FLINT_LOCK_BLUNDERBUSS_AMMO, 1, 2.0f, 15.0f,5, 80, 30,false),
    FLINTLOCK_PISTOL(ArmoryProjectileMaterial.FLINT_LOCK_PISTOL_AMMO, 1, 1.5f, 3.0f, 80,5, 30,true);

    ArmoryRangedMaterial(ArmoryProjectileMaterial ammo, int magazinCapasity, float projectileVelocity, float spread, int durability, int enchantability, int reloadtime, boolean duelWield) {
        this.ammoType = ammo;
        this.magazinCapasity = magazinCapasity;
        this.durability = durability;
        this.reloadTime = reloadtime;
        this.projectileVelocity = projectileVelocity;
        this.spread = spread;
        this.oneHanded = duelWield;
        this.enchantability = enchantability;
    }

    public final ArmoryProjectileMaterial ammoType;
    public final int durability, magazinCapasity, reloadTime;
    public final float projectileVelocity, spread;
    public final boolean oneHanded;
    private final int enchantability;
}
