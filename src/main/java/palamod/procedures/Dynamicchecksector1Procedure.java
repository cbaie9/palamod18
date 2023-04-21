package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class Dynamicchecksector1Procedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.MINAGEDCLAYER) == true && entity.getY() < 150 && entity.getY() > 128) {
			return true;
		}
		return false;
	}
}