package cn.kycraft.tinywagon.item;

import cn.kycraft.tinywagon.registeries.TinyWagonRegistry;
import lib.kasuga.registration.minecraft.item.ItemReg;
import net.minecraft.world.item.Item;

public class BufferStopItems {
    public static final ItemReg<Item> BUFFER_STOP_ITEMS = new ItemReg<>("buffer_stop",reg ->props -> new BufferStopItem(props)).setParent(TinyWagonRegistry.COMMON);

    public static void bootstrap(){}

    private BufferStopItems(){}
}
