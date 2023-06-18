
package palamod.client.screens;

import palamod.procedures.ReturnsnapshotoverlayProcedure;
import palamod.procedures.PalamodgameserververProcedure;
import palamod.procedures.DevchecksnapProcedure;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SnapshotOverlay {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
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
			if (DevchecksnapProcedure.execute(entity))
				Minecraft.getInstance().font.draw(event.getPoseStack(), Component.translatable("gui.palamod.snapshot.label_paladium_creator_footage_devlopp"), posX + -212, posY + -110, -26368);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					ReturnsnapshotoverlayProcedure.execute(world, entity), posX + -213, posY + -120, -3407872);
			Minecraft.getInstance().font.draw(event.getPoseStack(),

					PalamodgameserververProcedure.execute(world), posX + 109, posY + 110, -39424);
		}
	}
}
