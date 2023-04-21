package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelporetrans5Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Titane : Resitant,tres bon pour ses premiers outils";
		}
		return "Titane : Durable, a very good start for his first tools";
	}
}
