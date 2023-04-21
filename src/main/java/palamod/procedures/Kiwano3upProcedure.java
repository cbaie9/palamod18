package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class Kiwano3upProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (new Random().nextInt(100 + 1) == 1 && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.FARMLAND) {
			world.setBlock(new BlockPos(x, y, z), PalamodModBlocks.KIWANO_4.get().defaultBlockState(), 3);
		}
	}
}
