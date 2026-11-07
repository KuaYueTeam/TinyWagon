package cn.kycraft.tinywagon.block;

import cn.kycraft.tinywagon.registeries.TinyWagonRegistry;
import lib.kasuga.registration.minecraft.block.BlockReg;

public class RailBufferStopBlocks {
    public static  final BlockReg<RailBufferStopBlock> RAIL_BUFFER_STOP_BLOCK_REG =
            BlockReg.of("rail_buffer_stop",RailBufferStopBlock::new)
                    .strength(1.0f,1.0f)
                    .setParent(TinyWagonRegistry.COMMON);
    public static void bootstrop(){}

    private RailBufferStopBlocks(){}
}
