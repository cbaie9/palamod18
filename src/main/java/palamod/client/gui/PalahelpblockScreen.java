
package palamod.client.gui;

import palamod.world.inventory.PalahelpblockMenu;

import palamod.network.PalahelpblockButtonMessage;

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

public class PalahelpblockScreen extends AbstractContainerScreen<PalahelpblockMenu> {
	private final static HashMap<String, Object> guistate = PalahelpblockMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ore;
	Button button_trees;
	Button button_back;
	Button button_machine;
	Button button_fluid;
	Button button_close;

	public PalahelpblockScreen(PalahelpblockMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 150;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palahelpblock.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/pack.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 16, 0, 0, 63, 63, 63, 63);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpblock.label_palahelp_block_menu"), 11, 3, -65536);
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
		button_ore = new Button(this.leftPos + 96, this.topPos + 23, 40, 20, new TranslatableComponent("gui.palamod.palahelpblock.button_ore"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(0, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_ore", button_ore);
		this.addRenderableWidget(button_ore);
		button_trees = new Button(this.leftPos + 96, this.topPos + 48, 50, 20, new TranslatableComponent("gui.palamod.palahelpblock.button_trees"), e -> {
		});
		guistate.put("button:button_trees", button_trees);
		this.addRenderableWidget(button_trees);
		button_back = new Button(this.leftPos + 6, this.topPos + 87, 50, 20, new TranslatableComponent("gui.palamod.palahelpblock.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(2, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_machine = new Button(this.leftPos + 95, this.topPos + 75, 60, 20, new TranslatableComponent("gui.palamod.palahelpblock.button_machine"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(3, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_machine", button_machine);
		this.addRenderableWidget(button_machine);
		button_fluid = new Button(this.leftPos + 96, this.topPos + 104, 50, 20, new TranslatableComponent("gui.palamod.palahelpblock.button_fluid"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(4, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_fluid", button_fluid);
		this.addRenderableWidget(button_fluid);
		button_close = new Button(this.leftPos + 6, this.topPos + 114, 50, 20, new TranslatableComponent("gui.palamod.palahelpblock.button_close"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(5, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_close", button_close);
		this.addRenderableWidget(button_close);
	}
}
