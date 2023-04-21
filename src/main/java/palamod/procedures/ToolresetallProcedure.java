package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ToolresetallProcedure {
	public static void execute(LevelAccessor world) {
		world.setBlock(new BlockPos(0, 10, 0), PalamodModBlocks.NBTBLOCK.get().defaultBlockState(), 3);
		world.setBlock(new BlockPos(0, 11, 0), PalamodModBlocks.TRIXIUMNBTBLOCK.get().defaultBlockState(), 3);
	}
}
