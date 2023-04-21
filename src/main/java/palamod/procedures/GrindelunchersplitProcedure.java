package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class GrindelunchersplitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (PalamodserverconfirgurationConfiguration.GRINDER_CUSTOM.get()) {
			Gcodev4splitcustomProcedure.execute(world, x, y, z, entity);
		} else {
			Gcodev4splitProcedure.execute(world, x, y, z, entity);
		}
	}
}
