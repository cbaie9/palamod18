package palamod.procedures;

public class PalamodgameverProcedure {
	public static String execute() {
		double beta_num = 0;
		double build = 0;
		double devloppement_stade = 0;
		String minecraft_version = "";
		String update_name = "";
		String devloppement_name = "";
		String version_letter = "";
		String build_formated = "";
		minecraft_version = "1.18";
		beta_num = 1.19;
		build = 25;
		devloppement_stade = 3;
		update_name = "Cat";
		if (build >= 1000) {
			build_formated = "" + build;
		} else if (build >= 100) {
			build_formated = "0" + build;
		} else if (build >= 10) {
			build_formated = "00" + build;
		} else if (build >= 1) {
			build_formated = "000" + build;
		}
		if ((minecraft_version).equals("1.16")) {
			version_letter = "a";
		} else if ((minecraft_version).equals("1.12")) {
			version_letter = "b";
		} else if ((minecraft_version).equals("1.17")) {
			version_letter = "c";
		} else if ((minecraft_version).equals("1.18")) {
			version_letter = "d";
		} else if ((minecraft_version).equals("1.19.2")) {
			version_letter = "e";
		} else if ((minecraft_version).equals("1.19.4")) {
			version_letter = "ea";
		} else if ((minecraft_version).equals("1.20")) {
			version_letter = "f";
		} else if ((minecraft_version).equals("1.21")) {
			version_letter = "g";
		} else if ((minecraft_version).equals("1.22")) {
			version_letter = "h";
		}
		if (devloppement_stade == 4) {
			devloppement_name = "Release";
		} else if (devloppement_stade == 3) {
			devloppement_name = "Pr\u00E9-Release";
		} else if (devloppement_stade == 2) {
			devloppement_name = "Snapshot";
		} else {
			devloppement_name = "Beta test";
		}
		return "Palamod Renew \"" + "" + update_name + " \" " + devloppement_name + " build " + beta_num + version_letter + build_formated;
	}
}
