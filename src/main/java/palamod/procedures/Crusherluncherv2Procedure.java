package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

import net.minecraft.world.level.LevelAccessor;

public class Crusherluncherv2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PalamodserverconfirgurationConfiguration.CRUSHER_CUSTOM.get()) {
			PaladiumcrusherV2customProcedure.execute(world, x, y, z);
		} else {
			PaladiumcrusherV2Procedure.execute(world, x, y, z);
		}
	}
}
