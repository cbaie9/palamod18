package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

public class ChecksumcrusherProcedure {
	public static boolean execute() {
		double output = 0;
		boolean valid = false;
		boolean crusher_valid = false;
		boolean Grinder_valid = false;
		if (PalamodserverconfirgurationConfiguration.CRUSHER_CUSTOM.get()) {
			if (0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_AMETHYST.get() && 0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_TITANE.get() && 0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_PALADIUM.get()
					&& 0 < (double) PalamodserverconfirgurationConfiguration.CRUSHER_ENDIUM.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_AMETHYST.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_AMETHYST.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_TITANE.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_TITANE.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_PALADIUM.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_PALADIUM.get() && 0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_ENDIUM.get()
					&& 64 >= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_ENDIUM.get()) {
				if (0 <= (double) PalamodserverconfirgurationConfiguration.CRUSHER_OUT_ENDIUM.get()) {
					crusher_valid = true;
				} else {
					crusher_valid = false;
				}
			} else {
				crusher_valid = false;
			}
		} else {
			valid = true;
		}
		if (Grinder_valid || valid) {
			return true;
		}
		return false;
	}
}
