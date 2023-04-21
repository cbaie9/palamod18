package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelporetrans3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Paladium : Le minerais minable le plus puissant";
		}
		return "Paladium : The more powerful mineable ore";
	}
}
