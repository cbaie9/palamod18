package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelporetrans0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Endium : Le materiau ultime obtenable";
		}
		return "Endium : The ultimate obtenable ore";
	}
}
