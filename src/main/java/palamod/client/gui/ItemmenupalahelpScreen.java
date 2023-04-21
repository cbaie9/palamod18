
package palamod.client.gui;

import palamod.world.inventory.ItemmenupalahelpMenu;

import palamod.network.ItemmenupalahelpButtonMessage;

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

public class ItemmenupalahelpScreen extends AbstractContainerScreen<ItemmenupalahelpMenu> {
	private final static HashMap<String, Object> guistate = ItemmenupalahelpMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_legendary_stone;
	Button button_btons;
	Button button_armor;
	Button button_xp_bush_xp_berries;

	public ItemmenupalahelpScreen(ItemmenupalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/itemmenupalahelp.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/forest32.png"));
		this.blit(ms, this.leftPos + 8, this.topPos + 8, 0, 0, 32, 16, 32, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/desert16.png"));
		this.blit(ms, this.leftPos + 8, this.topPos + 24, 0, 0, 17, 16, 17, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/fish32.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 24, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/lake32.png"));
		this.blit(ms, this.leftPos + 8, this.topPos + 56, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/nether32.png"));
		this.blit(ms, this.leftPos + 8, this.topPos + 87, 0, 0, 32, 16, 32, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/plains16.png"));
		this.blit(ms, this.leftPos + 8, this.topPos + 40, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.itemmenupalahelp.label_item_menu"), 69, 7, -65536);
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
		button_back = new Button(this.leftPos + 3, this.topPos + 141, 45, 20, new TranslatableComponent("gui.palamod.itemmenupalahelp.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(0, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_legendary_stone = new Button(this.leftPos + 65, this.topPos + 26, 100, 20, new TranslatableComponent("gui.palamod.itemmenupalahelp.button_legendary_stone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(1, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_legendary_stone", button_legendary_stone);
		this.addRenderableWidget(button_legendary_stone);
		button_btons = new Button(this.leftPos + 115, this.topPos + 47, 50, 20, new TranslatableComponent("gui.palamod.itemmenupalahelp.button_btons"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(2, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_btons", button_btons);
		this.addRenderableWidget(button_btons);
		button_armor = new Button(this.leftPos + 115, this.topPos + 68, 50, 20, new TranslatableComponent("gui.palamod.itemmenupalahelp.button_armor"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(3, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_armor", button_armor);
		this.addRenderableWidget(button_armor);
		button_xp_bush_xp_berries = new Button(this.leftPos + 40, this.topPos + 89, 125, 20, new TranslatableComponent("gui.palamod.itemmenupalahelp.button_xp_bush_xp_berries"), e -> {
		});
		guistate.put("button:button_xp_bush_xp_berries", button_xp_bush_xp_berries);
		this.addRenderableWidget(button_xp_bush_xp_berries);
	}
}
