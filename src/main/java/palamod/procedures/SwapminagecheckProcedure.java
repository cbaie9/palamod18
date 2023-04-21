package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.level.LevelAccessor;

public class SwapminagecheckProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.MINAGEDCLAYER) == false) {
			return true;
		}
		return false;
	}
}
