package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

public class Crushertextad3Procedure {
	public static boolean execute() {
		if (32 != (double) PalamodserverconfirgurationConfiguration.CRUSHER_TITANE.get()) {
			return true;
		}
		return false;
	}
}
