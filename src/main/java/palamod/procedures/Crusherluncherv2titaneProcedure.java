package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

import net.minecraft.world.level.LevelAccessor;

public class Crusherluncherv2titaneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PalamodserverconfirgurationConfiguration.CRUSHER_CUSTOM.get()) {
			Crusherv2titanecustomProcedure.execute(world, x, y, z);
		} else {
			Crusherv2titaneProcedure.execute(world, x, y, z);
		}
	}
}
