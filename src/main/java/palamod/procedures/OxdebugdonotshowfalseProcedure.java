package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class OxdebugdonotshowfalseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("debug_donotshow", false);
	}
}
