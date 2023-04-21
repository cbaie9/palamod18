package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class DynamiccheckendiumfullverProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.MINAGEDCLAYER) == false && (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("Minage_setlayer_dynamic_enda_" + entity.getDisplayName().getString())) || (new ResourceLocation("palamod:forestender").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
				|| new ResourceLocation("palamod:frozenforest").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
				|| new ResourceLocation("palamod:roofedforest").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName()) || new ResourceLocation("plains").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
				|| new ResourceLocation("forest").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName()) || new ResourceLocation("forest").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
				|| new ResourceLocation("ocean").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())) && new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos(0, 10, 0), ("Minage_setlayer_dynamic_enda_hide_" + entity.getDisplayName().getString()))) && entity.getY() < 128 && entity.getY() > -64) {
			return true;
		}
		return false;
	}
}
