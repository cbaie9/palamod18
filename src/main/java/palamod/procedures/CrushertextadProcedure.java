package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

public class CrushertextadProcedure {
	public static boolean execute() {
		if (128 != (double) PalamodserverconfirgurationConfiguration.CRUSHER_ENDIUM.get()) {
			return true;
		}
		return false;
	}
}
