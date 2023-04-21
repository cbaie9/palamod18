package palamod.init;

import palamod.configuration.PalamodserverconfirgurationConfiguration;
import palamod.configuration.PalamodconfirgurationfileConfiguration;

import palamod.PalamodMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = PalamodMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PalamodModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PalamodconfirgurationfileConfiguration.SPEC, "Palamod_client_settings.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, PalamodserverconfirgurationConfiguration.SPEC, "palamod_server_conf.toml");
		});
	}
}
