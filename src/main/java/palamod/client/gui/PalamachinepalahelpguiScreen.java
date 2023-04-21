
package palamod.client.gui;

import palamod.world.inventory.PalamachinepalahelpguiMenu;

import palamod.procedures.Palahelppalamachine4Procedure;
import palamod.procedures.Palahelppalamachine3Procedure;
import palamod.procedures.Palahelppalamachine2Procedure;
import palamod.procedures.Palahelppalamachine1Procedure;
import palamod.procedures.Palahelppalamachine0Procedure;

import palamod.network.PalamachinepalahelpguiButtonMessage;

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

public class PalamachinepalahelpguiScreen extends AbstractContainerScreen<PalamachinepalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = PalamachinepalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;

	public PalamachinepalahelpguiScreen(PalamachinepalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 215;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palamachinepalahelpgui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/palamachine_guiscreenshotnew.png"));
		this.blit(ms, this.leftPos + 28, this.topPos + 93, 0, 0, 150, 70, 150, 70);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palamachinepalahelpgui.label_palamachine"), 77, 17, -12829636);
		this.font.draw(poseStack,

				Palahelppalamachine0Procedure.execute(entity), 4, 33, -12829636);
		this.font.draw(poseStack,

				Palahelppalamachine1Procedure.execute(entity), 4, 46, -12829636);
		this.font.draw(poseStack,

				Palahelppalamachine2Procedure.execute(entity), 4, 58, -12829636);
		this.font.draw(poseStack,

				Palahelppalamachine3Procedure.execute(entity), 6, 77, -12829636);
		this.font.draw(poseStack,

				Palahelppalamachine4Procedure.execute(entity), 55, 184, -3394816);
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
		button_back = new Button(this.leftPos + 17, this.topPos + 7, 45, 20, new TranslatableComponent("gui.palamod.palamachinepalahelpgui.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalamachinepalahelpguiButtonMessage(0, x, y, z));
				PalamachinepalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 145, this.topPos + 7, 45, 20, new TranslatableComponent("gui.palamod.palamachinepalahelpgui.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalamachinepalahelpguiButtonMessage(1, x, y, z));
				PalamachinepalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
