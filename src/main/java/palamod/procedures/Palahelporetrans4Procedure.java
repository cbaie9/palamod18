package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelporetrans4Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "Findium : Minerais qui sert a certains crafts";
		}
		return "Findium : Ore that serves some crafts";
	}
}
