
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.network.FactionblindingMessage;
import palamod.network.AdminshopkeyblindingMessage;

import palamod.PalamodMod;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PalamodModKeyMappings {
	public static final KeyMapping ADMINSHOPKEYBLINDING = new KeyMapping("key.palamod.adminshopkeyblinding", GLFW.GLFW_KEY_O, "key.categories.palamod");
	public static final KeyMapping FACTIONBLINDING = new KeyMapping("key.palamod.factionblinding", GLFW.GLFW_KEY_F, "key.categories.palamod");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(ADMINSHOPKEYBLINDING);
		ClientRegistry.registerKeyBinding(FACTIONBLINDING);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == ADMINSHOPKEYBLINDING.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopkeyblindingMessage(0, 0));
						AdminshopkeyblindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == FACTIONBLINDING.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						PalamodMod.PACKET_HANDLER.sendToServer(new FactionblindingMessage(0, 0));
						FactionblindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
