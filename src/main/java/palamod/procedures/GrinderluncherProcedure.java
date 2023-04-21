package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

import net.minecraft.world.level.LevelAccessor;

public class GrinderluncherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PalamodserverconfirgurationConfiguration.GRINDER_CUSTOM.get()) {
			Gcodev4customProcedure.execute(world, x, y, z);
		} else {
			Gcodev4Procedure.execute(world, x, y, z);
		}
	}
}
