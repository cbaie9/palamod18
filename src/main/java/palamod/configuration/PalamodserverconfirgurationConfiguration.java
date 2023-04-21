package palamod.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class PalamodserverconfirgurationConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CRUSHER_CUSTOM;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_AMETHYST;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_TITANE;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_PALADIUM;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_ENDIUM;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_OUT_AMETHYST;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_OUT_TITANE;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_OUT_PALADIUM;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_OUT_ENDIUM;
	public static final ForgeConfigSpec.ConfigValue<Double> CRUSHER_STATE;
	public static final ForgeConfigSpec.ConfigValue<Double> GNUM_MAX;
	public static final ForgeConfigSpec.ConfigValue<Double> GRINDER_STATE1;
	public static final ForgeConfigSpec.ConfigValue<Double> GRINDER_STATE2;
	public static final ForgeConfigSpec.ConfigValue<Double> GRINDER_STATE3;
	public static final ForgeConfigSpec.ConfigValue<Double> MULT_ENTRY;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GRINDER_CUSTOM;
	static {
		BUILDER.push("machine : Crusher");
		CRUSHER_CUSTOM = BUILDER.define("crusher_cheats", false);
		CRUSHER_AMETHYST = BUILDER.define("cc_ame", (double) 16);
		CRUSHER_TITANE = BUILDER.define("cc_tt", (double) 32);
		CRUSHER_PALADIUM = BUILDER.define("cc_pala", (double) 64);
		CRUSHER_ENDIUM = BUILDER.define("cc_end", (double) 128);
		BUILDER.comment("Crusher custom outputs (variable < 64 )");
		CRUSHER_OUT_AMETHYST = BUILDER.define("cco_ame", (double) 5);
		CRUSHER_OUT_TITANE = BUILDER.define("cco_tt", (double) 15);
		CRUSHER_OUT_PALADIUM = BUILDER.define("cco_pala", (double) 15);
		CRUSHER_OUT_ENDIUM = BUILDER.define("cco_end", (double) 1);
		BUILDER.comment("loading time ( time to smelt the fruits ), must be superior to 0");
		CRUSHER_STATE = BUILDER.define("loadingtime", (double) 10);
		BUILDER.pop();
		BUILDER.push("Machine : Grinder");
		BUILDER.comment("Grinder Settings");
		GNUM_MAX = BUILDER.define("Grinder capacty", (double) 100);
		BUILDER.comment("loading time ( time to smelt the ingot , create a hammer ), must be superior to 0");
		GRINDER_STATE1 = BUILDER.define("loading_time1", (double) 4);
		GRINDER_STATE2 = BUILDER.define("loading_time2", (double) 10);
		GRINDER_STATE3 = BUILDER.define("loading_time3", (double) 10);
		MULT_ENTRY = BUILDER.define("beta_mult1", (double) 1);
		GRINDER_CUSTOM = BUILDER.define("grinder_cheats", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
