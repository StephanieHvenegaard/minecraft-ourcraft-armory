/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the_nights.ourcraft_core.core.item.part;

import com.the_nights.ourcraft_core.core.item.material.RangedMaterial;

/**
 *
 * @author Stephanie
 */
public class FirearmPart {

    private int MagCount;
    private boolean loaded;
    private RangedMaterial specs;

    public FirearmPart(RangedMaterial specs) {
        this.specs = specs;
    }

    public int getDamage() {
        return specs.durability;

    }
    public RangedMaterial getSpecs()
    {
        return this.specs;
    }
    public void setSpecs(RangedMaterial specs)
    {
        this.specs = specs;
    }
    
    
    
    
    
    
}
