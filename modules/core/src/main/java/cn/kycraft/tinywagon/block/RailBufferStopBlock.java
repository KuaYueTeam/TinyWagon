package cn.kycraft.tinywagon.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RailBufferStopBlock extends Block {
    public RailBufferStopBlock(BlockBehaviour.Properties properties){
        super(properties);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos blockPos){
        BlockPos below = blockPos.below();
        return level.getBlockState(below).isFaceSturdy(level,below, Direction.UP);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos,BlockPos neighborPos){
        if (direction == Direction.DOWN && !this.canSurvive(state,level,pos)){
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state,direction,neighborState,level,pos,neighborPos);
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos){
        ItemStack tool = player.getMainHandItem();
        if (!tool.is(ItemTags.PICKAXES)){
            return 0.0F;
        }
        return super.getDestroyProgress(state,player,level,pos);
    }
}