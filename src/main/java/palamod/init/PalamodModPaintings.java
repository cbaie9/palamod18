
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.decoration.Motive;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PalamodModPaintings {
	@SubscribeEvent
	public static void registerMotives(RegistryEvent.Register<Motive> event) {
		event.getRegistry().register(new Motive(16, 16).setRegistryName("luckypainting"));
		event.getRegistry().register(new Motive(16, 16).setRegistryName("tsuamie_16"));
		event.getRegistry().register(new Motive(16, 16).setRegistryName("sunrise_116"));
		event.getRegistry().register(new Motive(16, 16).setRegistryName("sunrise_216"));
		event.getRegistry().register(new Motive(16, 16).setRegistryName("sunrise_316"));
		event.getRegistry().register(new Motive(16, 16).setRegistryName("desertpaining_16"));
		event.getRegistry().register(new Motive(16, 16).setRegistryName("plains_16"));
		event.getRegistry().register(new Motive(32, 16).setRegistryName("plains_32"));
		event.getRegistry().register(new Motive(32, 16).setRegistryName("nether_32"));
		event.getRegistry().register(new Motive(32, 16).setRegistryName("papillusion_32"));
		event.getRegistry().register(new Motive(32, 16).setRegistryName("sunrise_432"));
		event.getRegistry().register(new Motive(64, 64).setRegistryName("golem_64"));
		event.getRegistry().register(new Motive(64, 32).setRegistryName("papillusion_322"));
		event.getRegistry().register(new Motive(32, 32).setRegistryName("fish_32"));
		event.getRegistry().register(new Motive(32, 32).setRegistryName("forest_32"));
		event.getRegistry().register(new Motive(32, 32).setRegistryName("road_32"));
		event.getRegistry().register(new Motive(16, 32).setRegistryName("forest_332"));
	}
}
