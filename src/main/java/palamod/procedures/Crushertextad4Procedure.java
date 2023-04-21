package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

public class Crushertextad4Procedure {
	public static boolean execute() {
		if (16 != (double) PalamodserverconfirgurationConfiguration.CRUSHER_AMETHYST.get()) {
			return true;
		}
		return false;
	}
}
