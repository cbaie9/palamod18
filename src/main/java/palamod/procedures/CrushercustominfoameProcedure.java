package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CrushercustominfoameProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "crusher_num_amethyst")) + " / " + (double) PalamodserverconfirgurationConfiguration.CRUSHER_AMETHYST.get();
	}
}
