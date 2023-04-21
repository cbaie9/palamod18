package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelporetrans2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Paladium vert : equivalent en plus rare";
		}
		return "Green Paladium : equivalent but it more rare";
	}
}
