package palamod.procedures;

import palamod.configuration.PalamodserverconfirgurationConfiguration;

public class ChecksumgrinderProcedure {
	public static boolean execute() {
		double output = 0;
		boolean valid = false;
		boolean crusher_valid = false;
		boolean Grinder_valid = false;
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
		if (Grinder_valid || valid) {
			return true;
		}
		return false;
	}
}
