package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelporetrans6Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Amethyste : Un minerais de bas niveau trouvable assez facilement";
		}
		return "Amethyst : Low level ore, easily findable in cave ";
	}
}
