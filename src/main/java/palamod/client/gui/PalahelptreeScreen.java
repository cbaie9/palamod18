
package palamod.client.gui;

import palamod.world.inventory.PalahelptreeMenu;

import palamod.procedures.Palahelptree7Procedure;
import palamod.procedures.Palahelptree6Procedure;
import palamod.procedures.Palahelptree5Procedure;
import palamod.procedures.Palahelptree4Procedure;
import palamod.procedures.Palahelptree3Procedure;
import palamod.procedures.Palahelptree2Procedure;
import palamod.procedures.Palahelptree1Procedure;
import palamod.procedures.Palahelptree0Procedure;

import palamod.network.PalahelptreeButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PalahelptreeScreen extends AbstractContainerScreen<PalahelptreeMenu> {
	private final static HashMap<String, Object> guistate = PalahelptreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;

	public PalahelptreeScreen(PalahelptreeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palahelptree.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/erable_log.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 4, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/jacaranda_log.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 36, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/judeecercis_log.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 68, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/ostrya_log.png"));
		this.blit(ms, this.leftPos + 4, this.topPos + 100, 0, 0, 32, 32, 32, 32);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,

				Palahelptree0Procedure.execute(entity), 37, 6, -52480);
		this.font.draw(poseStack,

				Palahelptree1Procedure.execute(entity), 37, 20, -52480);
		this.font.draw(poseStack,

				Palahelptree2Procedure.execute(entity), 35, 39, -6750055);
		this.font.draw(poseStack,

				Palahelptree3Procedure.execute(entity), 37, 52, -6750055);
		this.font.draw(poseStack,

				Palahelptree4Procedure.execute(entity), 38, 71, -12829636);
		this.font.draw(poseStack,

				Palahelptree5Procedure.execute(entity), 39, 82, -12829636);
		this.font.draw(poseStack,

				Palahelptree6Procedure.execute(entity), 38, 101, -13434727);
		this.font.draw(poseStack,

				Palahelptree7Procedure.execute(entity), 38, 113, -13434727);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_back = new Button(this.leftPos + 21, this.topPos + 134, 45, 20, new TranslatableComponent("gui.palamod.palahelptree.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelptreeButtonMessage(0, x, y, z));
				PalahelptreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 67, this.topPos + 134, 45, 20, new TranslatableComponent("gui.palamod.palahelptree.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelptreeButtonMessage(1, x, y, z));
				PalahelptreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
