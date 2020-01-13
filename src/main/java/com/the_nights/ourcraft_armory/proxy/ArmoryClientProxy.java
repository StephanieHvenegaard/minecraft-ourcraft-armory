package com.the_nights.ourcraft_armory.proxy;


import com.the_nights.ourcraft_armory.core.OurcraftArmory;
import com.the_nights.ourcraft_armory.overlay.armorbar.OverlayEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.minecraftforge.api.distmarker.Dist.CLIENT;

@Mod.EventBusSubscriber(CLIENT)
public class ArmoryClientProxy extends ArmoryCommonProxy
{
  public static OverlayEventHandler handler = new OverlayEventHandler();

    @Override
    public void postInit(FMLCommonSetupEvent event)
    {
        super.postInit(event);

        //Register Armor Renderer for events

        MinecraftForge.EVENT_BUS.register(handler);

        //Register event for configuration change
        OurcraftArmory.ConfigChange eventConfigChanged = new OurcraftArmory.ConfigChange();
        MinecraftForge.EVENT_BUS.register(eventConfigChanged);
    }

  @Override
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        new ConfigChangedEvent.OnConfigChangedEvent(OurcraftArmory.MODID,"stuff", false, false);
//        armorBarRenderer.forceUpdate();
    }


}