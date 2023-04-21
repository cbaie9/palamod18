package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpvalue0Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Bien plus dans le futur ;)";
		}
		return "More in the future ;)";
	}
}
