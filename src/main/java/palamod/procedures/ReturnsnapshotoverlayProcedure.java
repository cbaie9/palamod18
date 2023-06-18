package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ReturnsnapshotoverlayProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getBoolean("debug_donotshow")) {
			return "";
		}
		return entity.getDisplayName().getString() + " - " + PalamodgameverProcedure.execute(world);
	}
}
