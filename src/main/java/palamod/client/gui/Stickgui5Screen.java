
package palamod.client.gui;

import palamod.world.inventory.Stickgui5Menu;

import palamod.network.Stickgui5ButtonMessage;

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

public class Stickgui5Screen extends AbstractContainerScreen<Stickgui5Menu> {
	private final static HashMap<String, Object> guistate = Stickgui5Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_stick_prcdant;
	Button button_stick_suivant;
	Button button_item_menu;
	Button button_menu;

	public Stickgui5Screen(Stickgui5Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/stickgui_5.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/1hea.png"));
		this.blit(ms, this.leftPos + 1, this.topPos + 44, 0, 0, 262, 117, 262, 117);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/hyperjumpstick.png"));
		this.blit(ms, this.leftPos + 263, this.topPos + 36, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/hyperjumpstick.png"));
		this.blit(ms, this.leftPos + 122, this.topPos + 135, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.stickgui_5.label_hyperjump_vous_donne_saut_9_p"), 3, 33, -12829636);
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
		button_stick_prcdant = new Button(this.leftPos + 7, this.topPos + 8, 100, 20, new TranslatableComponent("gui.palamod.stickgui_5.button_stick_prcdant"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui5ButtonMessage(0, x, y, z));
				Stickgui5ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_stick_prcdant", button_stick_prcdant);
		this.addRenderableWidget(button_stick_prcdant);
		button_stick_suivant = new Button(this.leftPos + 112, this.topPos + 8, 90, 20, new TranslatableComponent("gui.palamod.stickgui_5.button_stick_suivant"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui5ButtonMessage(1, x, y, z));
				Stickgui5ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_stick_suivant", button_stick_suivant);
		this.addRenderableWidget(button_stick_suivant);
		button_item_menu = new Button(this.leftPos + 207, this.topPos + 8, 70, 20, new TranslatableComponent("gui.palamod.stickgui_5.button_item_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui5ButtonMessage(2, x, y, z));
				Stickgui5ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_item_menu", button_item_menu);
		this.addRenderableWidget(button_item_menu);
		button_menu = new Button(this.leftPos + 282, this.topPos + 8, 45, 20, new TranslatableComponent("gui.palamod.stickgui_5.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui5ButtonMessage(3, x, y, z));
				Stickgui5ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
