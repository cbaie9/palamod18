
package palamod.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.client.gui.screens.achievement.StatsScreen;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class OrelayerOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(ScreenEvent.DrawScreenEvent.Post event) {
		if (event.getScreen() instanceof StatsScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
			int posX = w / 2;
			int posY = h / 2;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level;
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			if (true) {
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_empty"), posX + -211, posY + -76, -1);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_paladium_64_15"), posX + -210, posY + -31, -3407872);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_endium_64_128_customs_p"), posX + -211, posY + -66, -16777114);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_green_paladium_64_128"), posX + -210, posY + -55, -13395712);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_titane_64_32"), posX + -210, posY + -20, -10066330);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_amethyst_64_80"), posX + -210, posY + -9, -6750055);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_findium_64_150"), posX + -210, posY + -45, -13312);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.palamod.orelayer.label_empty1"), posX + -211, posY + 2, -1);
			}
		}
	}
}
