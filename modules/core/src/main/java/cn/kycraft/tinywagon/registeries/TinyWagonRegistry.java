package cn.kycraft.tinywagon.registeries;

import cn.kycraft.tinywagon.TinyWagon;
import lib.kasuga.KasugaLib;
import lib.kasuga.KasugaLibRegistry;
import lib.kasuga.registration.Registry;

public class TinyWagonRegistry {
    public static final Registry COMMON = KasugaLibRegistry.getRegistryOf(TinyWagon.MODID);

    public static final Registry CLIENT = KasugaLibRegistry.getRegistryOf(TinyWagon.MODID);

    private TinyWagonRegistry(){}
}
