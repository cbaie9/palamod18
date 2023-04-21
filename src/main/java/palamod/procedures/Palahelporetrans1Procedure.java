package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelporetrans1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "via le crusher ( voir le wiki des machine )";
		}
		return "through the crusher ( see the machine wiki )";
	}
}
