package cn.kycraft.tinywagon.tabs;

import cn.kycraft.tinywagon.TinyWagon;
import cn.kycraft.tinywagon.block.RailBufferStopBlocks;
import cn.kycraft.tinywagon.item.BufferStopItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TWTabs {
    public static final DeferredRegister<CreativeModeTab> TWTabs =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinyWagon.MODID);

    public static final Supplier<CreativeModeTab> TW_TABS =
            TWTabs.register("tiny_wagon_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(RailBufferStopBlocks.RAIL_BUFFER_STOP_BLOCK_REG.getEntry()))
                    .title(Component.translatable("itemGroup.tiny_wagon_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BufferStopItems.BUFFER_STOP_ITEMS.getEntry());
                    }).build());

    public static  void register(IEventBus eventBus){
        TWTabs.register(eventBus);
    }
}
