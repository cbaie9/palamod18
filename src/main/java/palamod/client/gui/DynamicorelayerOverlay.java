
package palamod.client.gui;

import palamod.procedures.MinageprocessdynamicchecknbtProcedure;
import palamod.procedures.DynamicchecktitaneProcedure;
import palamod.procedures.Dynamicchecksector5Procedure;
import palamod.procedures.Dynamicchecksector4Procedure;
import palamod.procedures.Dynamicchecksector3Procedure;
import palamod.procedures.Dynamicchecksector2Procedure;
import palamod.procedures.Dynamicchecksector1Procedure;
import palamod.procedures.DynamiccheckendiumfullverenverProcedure;
import palamod.procedures.DynamiccheckendiumfullverProcedure;
import palamod.procedures.DynamiccheckamethystProcedure;
import palamod.procedures.DynamiccechkpaladiumProcedure;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class DynamicorelayerOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
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
			if (MinageprocessdynamicchecknbtProcedure.execute(entity)) {
				if (DynamiccheckendiumfullverProcedure.execute(world, x, y, z, entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_empty"), posX + -211, posY + -76, -1);
				if (DynamiccechkpaladiumProcedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_paladium_64_15"), posX + -210, posY + -9, -3407872);
				if (DynamiccheckendiumfullverProcedure.execute(world, x, y, z, entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_endium_64_128_customs_p"), posX + -211, posY + -66, -16777114);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_green_paladium_64_128"), posX + -210, posY + -55, -13395712);
				if (DynamicchecktitaneProcedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_titane_64_32"), posX + -210, posY + -20, -10066330);
				if (DynamiccheckamethystProcedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_amethyst_64_80"), posX + -211, posY + -32, -6750055);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_findium_64_150"), posX + -211, posY + -44, -13312);
				if (Dynamicchecksector5Procedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_empty1"), posX + -211, posY + 2, -1);
				if (Dynamicchecksector4Procedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_empty2"), posX + -210, posY + -9, -1);
				if (Dynamicchecksector3Procedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_empty3"), posX + -210, posY + -20, -1);
				if (DynamiccheckendiumfullverenverProcedure.execute(world, x, y, z, entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_empty4"), posX + -212, posY + -68, -1);
				if (Dynamicchecksector1Procedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_empty5"), posX + -210, posY + -45, -1);
				if (Dynamicchecksector2Procedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.palamod.dynamicorelayer.label_empty6"), posX + -210, posY + -31, -1);
			}
		}
	}
}
