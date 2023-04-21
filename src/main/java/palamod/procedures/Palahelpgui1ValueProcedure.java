package palamod.procedures;

import net.minecraft.world.entity.Entity;

public class Palahelpgui1ValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getPersistentData().getString("language")).equals("french")) {
			return "bientot";
		}
		return "soon";
	}
}
