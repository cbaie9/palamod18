package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class LunchallsetupProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Hdvsetup_processProcedure.execute(world);
		FactionsetupProcedure.execute(world, entity);
		AdminshoppricesetupProcedure.execute(world);
		TrixiumsetupProcedure.execute(world);
	}
}
