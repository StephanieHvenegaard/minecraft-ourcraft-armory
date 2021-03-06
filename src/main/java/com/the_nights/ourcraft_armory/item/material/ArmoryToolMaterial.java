/* 

MIT License

Copyright (c) 2019 Stephanie Hvenegaard

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

 */
package com.the_nights.ourcraft_armory.item.material;

import com.the_nights.ourcraft_armory.item.list.ObsidianItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

/**
 *
 * @author Stephanie
 */
public enum ArmoryToolMaterial implements IItemTier {
    //	Vanilla durability.
    // Wood: 60 uses
    // Stone: 132 uses
    // Iron: 251 uses
    // Golden: 33 uses
    // Diamond: 1562 uses

    // enchanting 
    // lether 15	
    // Golden 25
    // Chain mail 12
    // Iron 9	
    // turtle 9
    // Diamond 10
    Obsidian(15.0f, 5.0f, 20.0f, 1562 * 10, 3, 18, ObsidianItems.ingot),
    Emarald(10.0f, 3.0f, 15.0f, 1562 * 2, 3, 12, Items.EMERALD),
    Diamond(5.0f, 1.0f, 1.0f, 1562, 3, 10, Items.DIAMOND),
    Iron(4.0f, 1.0f, 1.0f, 251, 2, 9, Items.IRON_INGOT),
    Golden(2.0f, 1.0f, 1.0f, 33, 1, 25, Items.GOLD_INGOT),
    Bone(2.5f,1.0f,1.0f, 198, 1,18,Items.BONE ),
    Stone(3.0f, 1.0f, 1.0f, 132, 1, 9, Items.COBBLESTONE),
    Bamboo(2.2f,1.0f,1.0f,120,1,15,Items.BAMBOO),
    Wood(2.0f, 1.0f, 1.0f, 60, 1, 15, null),;

    private final float dmg;
    private final float effiency;
    private final int durability;
    private final int harvestLVL;
    private final int enchantAbility;
    private final Item repItem;
    private final float speed;

    /***
     * 
     * @param dmg value of 0 will give a damage of 2 
     * @param speed value of 0.0 will give a speed of 4
     * @param effiency
     * @param durability
     * @param harvestLVL
     * @param enchantAbility
     * @param repItem 
     */
    private ArmoryToolMaterial(float dmg, float speed, float effiency, int durability, int harvestLVL, int enchantAbility, Item repItem) {
        this.dmg = dmg;
        this.speed = speed;
        this.effiency = effiency;
        this.durability = durability;
        this.harvestLVL = harvestLVL;
        this.enchantAbility = enchantAbility;
        this.repItem = repItem;
    }

    @Override
    public int getMaxUses() {
        return durability;
    }

    @Override
    public float getEfficiency() {
        return effiency;
    }

    @Override
    public float getAttackDamage() {
        return dmg;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLVL;
    }

    @Override
    public int getEnchantability() {
        return enchantAbility;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repItem);
    }

    public float getSpeed() {
        return speed;
    }

}
