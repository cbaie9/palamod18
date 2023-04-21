
package palamod.client.gui;

import palamod.world.inventory.Grinderpalahelp2guiMenu;

import palamod.procedures.Palahelpgrinder32Procedure;
import palamod.procedures.Palahelpgrinder28Procedure;
import palamod.procedures.Palahelpgrinder27Procedure;
import palamod.procedures.Palahelpgrinder26Procedure;
import palamod.procedures.Palahelpgrinder25Procedure;
import palamod.procedures.Palahelpgrinder24Procedure;
import palamod.procedures.Palahelpgrinder23Procedure;
import palamod.procedures.Palahelpgrinder22Procedure;
import palamod.procedures.Palahelpgrinder21Procedure;
import palamod.procedures.Palahelpgrinder20Procedure;
import palamod.procedures.Palahelpgrinder202Procedure;

import palamod.network.Grinderpalahelp2guiButtonMessage;

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

public class Grinderpalahelp2guiScreen extends AbstractContainerScreen<Grinderpalahelp2guiMenu> {
	private final static HashMap<String, Object> guistate = Grinderpalahelp2guiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;

	public Grinderpalahelp2guiScreen(Grinderpalahelp2guiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 330;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/grinderpalahelp_2gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/grinder_block_front.png"));
		this.blit(ms, this.leftPos + 68, this.topPos + 3, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/1.png"));
		this.blit(ms, this.leftPos + 16, this.topPos + 144, 0, 0, 45, 46, 45, 46);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/2.png"));
		this.blit(ms, this.leftPos + 95, this.topPos + 145, 0, 0, 46, 46, 46, 46);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/1.png"));
		this.blit(ms, this.leftPos + 191, this.topPos + 145, 0, 0, 45, 46, 45, 46);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.grinderpalahelp_2gui.label_22"), 243, 5, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.grinderpalahelp_2gui.label_grinder_wiki"), 133, 6, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder20Procedure.execute(entity), 3, 37, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder21Procedure.execute(entity), 2, 57, -4385001);
		this.font.draw(poseStack,

				Palahelpgrinder22Procedure.execute(entity), 4, 68, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder23Procedure.execute(entity), 4, 80, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder25Procedure.execute(entity), 17, 133, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder24Procedure.execute(entity), 3, 107, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder26Procedure.execute(entity), 95, 133, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder27Procedure.execute(entity), 192, 133, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder28Procedure.execute(entity), 3, 120, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder32Procedure.execute(entity), 4, 93, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder202Procedure.execute(entity), 2, 46, -12829636);
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
		button_back = new Button(this.leftPos + 260, this.topPos + 169, 45, 20, new TranslatableComponent("gui.palamod.grinderpalahelp_2gui.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Grinderpalahelp2guiButtonMessage(0, x, y, z));
				Grinderpalahelp2guiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 260, this.topPos + 147, 45, 20, new TranslatableComponent("gui.palamod.grinderpalahelp_2gui.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Grinderpalahelp2guiButtonMessage(1, x, y, z));
				Grinderpalahelp2guiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
