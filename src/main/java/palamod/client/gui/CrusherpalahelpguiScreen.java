
package palamod.client.gui;

import palamod.world.inventory.CrusherpalahelpguiMenu;

import palamod.procedures.Palahelpcrusher9Procedure;
import palamod.procedures.Palahelpcrusher8Procedure;
import palamod.procedures.Palahelpcrusher7Procedure;
import palamod.procedures.Palahelpcrusher6Procedure;
import palamod.procedures.Palahelpcrusher4Procedure;
import palamod.procedures.Palahelpcrusher3Procedure;
import palamod.procedures.Palahelpcrusher2Procedure;
import palamod.procedures.Palahelpcrusher1Procedure;
import palamod.procedures.Palahelpcrusher13Procedure;
import palamod.procedures.Palahelpcrusher12Procedure;
import palamod.procedures.Palahelpcrusher11Procedure;
import palamod.procedures.Palahelpcrusher10Procedure;
import palamod.procedures.Palahelpcrusher0Procedure;

import palamod.network.CrusherpalahelpguiButtonMessage;

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

public class CrusherpalahelpguiScreen extends AbstractContainerScreen<CrusherpalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = CrusherpalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;
	Button button_gui;

	public CrusherpalahelpguiScreen(CrusherpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 420;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/crusherpalahelpgui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/crusher_front.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 5, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.crusherpalahelpgui.label_beta_nochange_0004"), 3, 184, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.crusherpalahelpgui.label_paladium_crusher_wiki"), 111, 3, -65485);
		this.font.draw(poseStack,

				Palahelpcrusher0Procedure.execute(entity), 4, 28, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher1Procedure.execute(entity), 4, 40, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher2Procedure.execute(entity), 3, 52, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher3Procedure.execute(entity), 4, 64, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher4Procedure.execute(entity), 4, 75, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher6Procedure.execute(entity), 3, 88, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher7Procedure.execute(entity), 3, 101, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher10Procedure.execute(entity), 247, 42, -256);
		this.font.draw(poseStack,

				Palahelpcrusher11Procedure.execute(entity), 341, 42, -16776961);
		this.font.draw(poseStack,

				Palahelpcrusher8Procedure.execute(entity), 3, 113, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher9Procedure.execute(entity), 4, 127, -12829636);
		this.font.draw(poseStack,

				Palahelpcrusher12Procedure.execute(entity), 5, 150, -26368);
		this.font.draw(poseStack,

				Palahelpcrusher13Procedure.execute(entity), 4, 161, -26368);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.crusherpalahelpgui.label_11_v1"), 374, 183, -12829636);
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
		button_back = new Button(this.leftPos + 211, this.topPos + 172, 45, 20, new TranslatableComponent("gui.palamod.crusherpalahelpgui.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiButtonMessage(0, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 260, this.topPos + 172, 45, 20, new TranslatableComponent("gui.palamod.crusherpalahelpgui.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiButtonMessage(1, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
		button_gui = new Button(this.leftPos + 241, this.topPos + 19, 86, 20, new TranslatableComponent("gui.palamod.crusherpalahelpgui.button_gui"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiButtonMessage(2, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_gui", button_gui);
		this.addRenderableWidget(button_gui);
	}
}
