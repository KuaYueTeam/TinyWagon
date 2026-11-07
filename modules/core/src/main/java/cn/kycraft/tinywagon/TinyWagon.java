package cn.kycraft.tinywagon;

import cn.kycraft.tinywagon.block.RailBufferStopBlocks;
import cn.kycraft.tinywagon.item.BufferStopItems;
import cn.kycraft.tinywagon.registeries.TinyWagonRegistry;
import cn.kycraft.tinywagon.tabs.TWTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(TinyWagon.MODID)
public class TinyWagon {

    public static final String MODID = "tiny_wagon";

    public static final Logger LOGGER = LogUtils.getLogger();


    public TinyWagon(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        BufferStopItems.bootstrap();
        RailBufferStopBlocks.bootstrop();
        TinyWagonRegistry.COMMON.register(modEventBus);
        TWTabs.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, TinyWagonConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (TinyWagonConfig.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", TinyWagonConfig.MAGIC_NUMBER_INTRODUCTION.get(), TinyWagonConfig.MAGIC_NUMBER.getAsInt());

        TinyWagonConfig.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("");
    }
}
