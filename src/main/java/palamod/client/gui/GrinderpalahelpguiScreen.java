
package palamod.client.gui;

import palamod.world.inventory.GrinderpalahelpguiMenu;

import palamod.procedures.Palahelpgrindet16Procedure;
import palamod.procedures.Palahelpgrinder19Procedure;
import palamod.procedures.Palahelpgrinder18Procedure;
import palamod.procedures.Palahelpgrinder17Procedure;
import palamod.procedures.Palahelpgrinder15Procedure;
import palamod.procedures.Palahelpgrinder14Procedure;
import palamod.procedures.Palahelpgrinder13Procedure;
import palamod.procedures.Palahelpgrinder12Procedure;
import palamod.procedures.Palahelpgrinder11Procedure;
import palamod.procedures.Palahelpgrinder10Procedure;

import palamod.network.GrinderpalahelpguiButtonMessage;

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

public class GrinderpalahelpguiScreen extends AbstractContainerScreen<GrinderpalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = GrinderpalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_next;
	Button button_menu;
	Button button_back;

	public GrinderpalahelpguiScreen(GrinderpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 330;
		this.imageHeight = 185;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/grinderpalahelpgui.png");

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
		this.blit(ms, this.leftPos + 48, this.topPos + 4, 0, 0, 32, 32, 32, 32);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.grinderpalahelpgui.label_grinder"), 145, 9, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder10Procedure.execute(entity), 3, 40, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder11Procedure.execute(entity), 3, 53, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder12Procedure.execute(entity), 3, 66, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder13Procedure.execute(entity), 2, 78, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder14Procedure.execute(entity), 3, 90, -256);
		this.font.draw(poseStack,

				Palahelpgrinder15Procedure.execute(entity), 2, 99, -256);
		this.font.draw(poseStack,

				Palahelpgrindet16Procedure.execute(entity), 3, 110, -8504309);
		this.font.draw(poseStack,

				Palahelpgrinder17Procedure.execute(entity), 3, 120, -816878);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.grinderpalahelpgui.label_empty"), 54, 71, -12829636);
		this.font.draw(poseStack,

				Palahelpgrinder18Procedure.execute(entity), 4, 132, -3335911);
		this.font.draw(poseStack,

				Palahelpgrinder19Procedure.execute(entity), 4, 145, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.grinderpalahelpgui.label_2_min_12"), 219, 4, -12829636);
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
		button_next = new Button(this.leftPos + 65, this.topPos + 159, 50, 20, new TranslatableComponent("gui.palamod.grinderpalahelpgui.button_next"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(0, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
		button_menu = new Button(this.leftPos + 123, this.topPos + 159, 45, 20, new TranslatableComponent("gui.palamod.grinderpalahelpgui.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(1, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
		button_back = new Button(this.leftPos + 184, this.topPos + 159, 45, 20, new TranslatableComponent("gui.palamod.grinderpalahelpgui.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(2, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
