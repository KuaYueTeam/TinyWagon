//package com.train.tinywagon.items;
//
//import com.train.tinywagon.TinyWagon;
//import net.minecraft.world.item.Item;
//import net.neoforged.bus.api.IEventBus;
//import net.neoforged.neoforge.registries.DeferredItem;
//import net.neoforged.neoforge.registries.DeferredRegister;
//
//public class BufferStop {
//    public static final DeferredRegister.Items ITEMS =
//            DeferredRegister.createItems(TinyWagon.MODID);
//
//    public static final DeferredItem<Item> BufferStop = ITEMS.register("BufferStop",()-> new Item(new Item.Properties()));
//
//    public static void register(IEventBus eventBus){
//        ITEMS.register(eventBus);
//    }
//}
