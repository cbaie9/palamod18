package palamod.procedures;

public class OxmodsreturnverProcedure {
	public static String execute() {
		return "The actual installed version is :" + PalamodgameverProcedure.execute();
	}
}
