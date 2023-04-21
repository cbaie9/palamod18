
package palamod.client.gui;

import palamod.world.inventory.Stickgui7Menu;

import palamod.network.Stickgui7ButtonMessage;

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

public class Stickgui7Screen extends AbstractContainerScreen<Stickgui7Menu> {
	private final static HashMap<String, Object> guistate = Stickgui7Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_stick_prcdant;
	Button button_item_menu;
	Button button_menu;

	public Stickgui7Screen(Stickgui7Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/stickgui_7.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/1amage.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 48, 0, 0, 261, 116, 261, 116);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/image27.png"));
		this.blit(ms, this.leftPos + 263, this.topPos + 72, 0, 0, 86, 86, 86, 86);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/damagestick.png"));
		this.blit(ms, this.leftPos + 287, this.topPos + 30, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/damagestick.png"));
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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.stickgui_7.label_damage_stick_cre_un_effet_de"), 3, 33, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.stickgui_7.label_craft_du_spike_en_paladium"), 264, 60, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.stickgui_7.label_empty"), 349, 73, -12829636);
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
		button_stick_prcdant = new Button(this.leftPos + 7, this.topPos + 8, 100, 20, new TranslatableComponent("gui.palamod.stickgui_7.button_stick_prcdant"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui7ButtonMessage(0, x, y, z));
				Stickgui7ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_stick_prcdant", button_stick_prcdant);
		this.addRenderableWidget(button_stick_prcdant);
		button_item_menu = new Button(this.leftPos + 125, this.topPos + 7, 70, 20, new TranslatableComponent("gui.palamod.stickgui_7.button_item_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui7ButtonMessage(1, x, y, z));
				Stickgui7ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_item_menu", button_item_menu);
		this.addRenderableWidget(button_item_menu);
		button_menu = new Button(this.leftPos + 212, this.topPos + 7, 45, 20, new TranslatableComponent("gui.palamod.stickgui_7.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui7ButtonMessage(2, x, y, z));
				Stickgui7ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
	}
}
