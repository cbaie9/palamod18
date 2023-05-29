package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnsnapshotoverlayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString() + " - " + PalamodgameverProcedure.execute();
	}
}
