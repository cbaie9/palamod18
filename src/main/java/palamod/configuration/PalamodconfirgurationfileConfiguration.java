package palamod.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class PalamodconfirgurationfileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<String> LANGUAGE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DEVMOD;
	public static final ForgeConfigSpec.ConfigValue<Boolean> CRUSHER_V2;
	static {
		BUILDER.push("Client");
		BUILDER.comment("french or english, default is english");
		LANGUAGE = BUILDER.define("language", "english");
		BUILDER.pop();
		BUILDER.push("Devlopper settings");
		DEVMOD = BUILDER.define("devmod", false);
		CRUSHER_V2 = BUILDER.define("nvv2crusher", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
