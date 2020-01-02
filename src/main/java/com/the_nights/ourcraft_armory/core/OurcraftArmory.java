package com.the_nights.ourcraft_armory.core;

import com.the_nights.ourcraft_core.core.OurcraftCore;
import com.the_nights.ourcraft_core.core.item.tool.ItemAxe;
import com.the_nights.ourcraft_armory.item.*;
import com.the_nights.ourcraft_armory.item.armor.*;
import com.the_nights.ourcraft_armory.item.material.ArmoryArmorMaterial;
import com.the_nights.ourcraft_armory.item.material.ArmoryRangedMaterial;
import com.the_nights.ourcraft_armory.item.material.ArmoryToolMaterial;
import com.the_nights.ourcraft_armory.item.tool.ItemHoe;
import com.the_nights.ourcraft_armory.item.tool.ItemPickAxe;
import com.the_nights.ourcraft_armory.item.tool.ItemShovel;
import com.the_nights.ourcraft_armory.item.weapon.ItemFireArm;
import com.the_nights.ourcraft_armory.item.weapon.ItemKatana;
import com.the_nights.ourcraft_armory.item.weapon.ItemScythe;
import com.the_nights.ourcraft_armory.item.weapon.ItemSword;
import com.the_nights.ourcraft_armory.proxy.ArmoryClientProxy;
import com.the_nights.ourcraft_armory.proxy.ArmoryCommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OurcraftArmory.MODID)
public class OurcraftArmory
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static OurcraftArmory INSTANCE;                                                // public instance of the main mod class
    public static final String MODID = "ourcraft-armory";

    public static ArmoryCommonProxy proxy = DistExecutor.runForDist(() -> ArmoryClientProxy::new, () -> ArmoryCommonProxy::new);

    public OurcraftArmory() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register the bakeConfigs method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::bakeConfigs);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        proxy.postInit(event);
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        // InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            // register a new item here
            event.getRegistry().registerAll(
                    // Sword
                    EmaraldItems.sword = new ItemSword(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emarald_sword")),
                    ObsidianItems.sword = new ItemSword(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_sword")),
                    // Katana
                    WoodenItem.katana = new ItemKatana(ArmoryToolMaterial.Wood, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_katana")),
                    StoneItems.katana = new ItemKatana(ArmoryToolMaterial.Stone, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("stone_katana")),
                    IronItems.katana = new ItemKatana(ArmoryToolMaterial.Iron, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("iron_katana")),
                    GoldenItems.katana = new ItemKatana(ArmoryToolMaterial.Golden, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("gold_katana")),
                    DiamondItem.katana = new ItemKatana(ArmoryToolMaterial.Diamond, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("diamond_katana")),
                    EmaraldItems.katana = new ItemKatana(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("emarald_katana")),
                    ObsidianItems.katana = new ItemKatana(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_katana")),
                    // -----------------------------
                    // ARMOR
                    // helmet
                    // new ArmorItem(ArmoryArmorMaterial.TURTLE, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_helmet")),
                    KelpArmor.helmet = new ArmorItem(ArmoryArmorMaterial.kelp, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("kelp_helmet")),
                    WoodenArmor.helmet = new ArmorItem(ArmoryArmorMaterial.wood, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_helmet")),
                    SapphireArmor.helmet = new ArmorItem(ArmoryArmorMaterial.Sapphire, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("sapphire_helmet")),
                    BlueGlassArmor.helmet = new ArmorItem(ArmoryArmorMaterial.blue_glass, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("blue_glass_helmet")),
                    ObsidianArmor.helmet = new ArmorItem(ArmoryArmorMaterial.obsidian, EquipmentSlotType.HEAD, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_helmet")),
                    // chest
                    KelpArmor.chestplate = new ArmorItem(ArmoryArmorMaterial.kelp, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("kelp_chest")),
                    WoodenArmor.chestplate = new ArmorItem(ArmoryArmorMaterial.wood, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_chest")),
                    SapphireArmor.chestplate = new ArmorItem(ArmoryArmorMaterial.Sapphire, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("sapphire_chest")),
                    BlueGlassArmor.chestplate = new ArmorItem(ArmoryArmorMaterial.blue_glass, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("blue_glass_chest")),
                    ObsidianArmor.chestplate = new ArmorItem(ArmoryArmorMaterial.obsidian, EquipmentSlotType.CHEST, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_chest")),
                    // leggings
                    KelpArmor.leggings = new ArmorItem(ArmoryArmorMaterial.kelp, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("kelp_leggings")),
                    WoodenArmor.leggings = new ArmorItem(ArmoryArmorMaterial.wood, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_leggings")),
                    SapphireArmor.leggings = new ArmorItem(ArmoryArmorMaterial.Sapphire, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("sapphire_leggings")),
                    BlueGlassArmor.leggings = new ArmorItem(ArmoryArmorMaterial.blue_glass, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("blue_glass_leggings")),
                    ObsidianArmor.leggings = new ArmorItem(ArmoryArmorMaterial.obsidian, EquipmentSlotType.LEGS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_leggings")),
                    // boots
                    KelpArmor.boots = new ArmorItem(ArmoryArmorMaterial.kelp, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("kelp_boots")),
                    WoodenArmor.boots = new ArmorItem(ArmoryArmorMaterial.wood, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("wood_boots")),
                    SapphireArmor.boots = new ArmorItem(ArmoryArmorMaterial.Sapphire, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("sapphire_boots")),
                    BlueGlassArmor.boots = new ArmorItem(ArmoryArmorMaterial.blue_glass, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("blue_glass_boots")),
                    ObsidianArmor.boots = new ArmorItem(ArmoryArmorMaterial.obsidian, EquipmentSlotType.FEET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("obsidian_boots")),

                    //TOOLS
                    // Axe
                    EmaraldItems.axe = new ItemAxe(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_axe")),
                    ObsidianItems.axe = new ItemAxe(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_axe")),
                    // Hoe
                    EmaraldItems.hoe = new ItemHoe(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_hoe")),
                    ObsidianItems.hoe = new ItemScythe(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_hoe")),
                    // spade
                    EmaraldItems.spade = new ItemShovel(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_spade")),
                    ObsidianItems.spade = new ItemShovel(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_spade")),
                    // pickaxe
                    EmaraldItems.pickaxe = new ItemPickAxe(ArmoryToolMaterial.Emarald, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("emarald_pickaxe")),
                    ObsidianItems.pickaxe = new ItemPickAxe(ArmoryToolMaterial.Obsidian, new Item.Properties().group(ArmoryGroup.TOOLS)).setRegistryName(getLocation("obsidian_pickaxe")),

                    // Misc
                    BlueGlassItems.ingot = new Item(new Item.Properties().group(OurcraftCore.OURCRAFT_GROUP)).setRegistryName(getLocation("blue_glass_ingot")),
                    BlueGlassItems.dust = new Item(new Item.Properties().group(OurcraftCore.OURCRAFT_GROUP)).setRegistryName(getLocation("blue_glass_dust")),







                    // Firearms
                    IronItems.musket = new ItemFireArm(ArmoryRangedMaterial.FLINTLOCK_MUSKET, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_musket")),
                    IronItems.blunderbuss = new ItemFireArm(ArmoryRangedMaterial.FLINTLOCK_BLUNDERBUSS, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_blunderbuss")),
                    IronItems.pistol = new ItemFireArm(ArmoryRangedMaterial.FLINTLOCK_PISTOL, new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_pistol")),

                    MiscItems.blunderAmmo = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("blunderbuss_ammo")),
                    MiscItems.flintlockAmmo = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_ammo")),
                    MiscItems.blunderBarrelAssembly = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_blunderbuss_barrelassembly")),
                    MiscItems.musketBarrelAssembly = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("flintlock_musket_barrelassembly")),
                    MiscItems.gunstock = new Item(new Item.Properties().group(ArmoryGroup.COMBAT)).setRegistryName(getLocation("gunstock"))

            );
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
        private static ResourceLocation getLocation(String name) {
            return new ResourceLocation(MODID, name);
        }
    }
    /* ========================================================
Other Crap
======================================================== */
    @SubscribeEvent
    public void bakeConfigs(ModConfig.ModConfigEvent event) {
        if (event.getConfig().getSpec() == Configs.CLIENT_SPEC) {
            Configs.bake();
        }
    }
    public static class ConfigChange {

        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            //Only process events for this mod
            if (event.getModID().equals(MODID)) {
                proxy.onConfigChanged(event);
            }
        }
    }
}
