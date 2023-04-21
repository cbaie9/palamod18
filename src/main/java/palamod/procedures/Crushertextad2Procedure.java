package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

public class Crushertextad2Procedure {
	public static boolean execute() {
		if (64 != (double) PalamodserverconfirgurationConfiguration.CRUSHER_PALADIUM.get()) {
			return true;
		}
		return false;
	}
}
