package cn.kycraft.tinywagon.item;

import cn.kycraft.tinywagon.block.RailBufferStopBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class BufferStopItem extends Item {
   public BufferStopItem(Properties properties){
       super(properties.stacksTo(64));
   }

   @Override
    public InteractionResult useOn(UseOnContext useOnContext){
        Level level = useOnContext.getLevel();
        BlockPos railPos = useOnContext.getClickedPos();
        BlockState clicked = level.getBlockState(railPos);

        if (!clicked.is(Blocks.RAIL)){
            return InteractionResult.PASS;
        }

        BlockPos below = railPos.below();
        if (!level.getBlockState(below).isFaceSturdy(level,below,Direction.UP)){
            return InteractionResult.PASS;
        }

        BlockState newState = RailBufferStopBlocks.RAIL_BUFFER_STOP_BLOCK_REG.getEntry().defaultBlockState();
        if (!newState.canSurvive(level,railPos)){
            return InteractionResult.PASS;
        }

        if (!level.isClientSide){
            level.setBlock(railPos,newState,Block.UPDATE_ALL);
            level.gameEvent(useOnContext.getPlayer(),GameEvent.BLOCK_PLACE,railPos);
        }

        if (useOnContext.getPlayer() instanceof ServerPlayer serverPlayer){
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            if (!serverPlayer.getAbilities().instabuild){
                useOnContext.getItemInHand().shrink(1);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
   }
}
