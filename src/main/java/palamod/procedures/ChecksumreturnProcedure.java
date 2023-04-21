package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

public class ChecksumreturnProcedure {
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
		if (PalamodserverconfirgurationConfiguration.GRINDER_CUSTOM.get()) {
			if (0 < (double) PalamodserverconfirgurationConfiguration.GNUM_MAX.get() && 0 < (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE1.get() && 0 < (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE2.get()
					&& 0 < (double) PalamodserverconfirgurationConfiguration.GRINDER_STATE3.get()) {
				Grinder_valid = true;
			} else {
				Grinder_valid = false;
			}
		} else {
			valid = true;
		}
		if (Grinder_valid && crusher_valid) {
			return true;
		}
		return false;
	}
}
