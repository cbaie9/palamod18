
package palamod.client.gui;

import palamod.world.inventory.AdminshopblockMenu;

import palamod.network.AdminshopblockButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshopblockScreen extends AbstractContainerScreen<AdminshopblockMenu> {
	private final static HashMap<String, Object> guistate = AdminshopblockMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_dirt;
	Button button_grass;
	Button button_stone;
	Button button_netherrack;
	Button button_soul_sand;
	Button button_sand;
	Button button_gravel;
	Button button_glowstone;
	Button button_oak_wood;
	Button button_blackstone;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;

	public AdminshopblockScreen(AdminshopblockMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 205;
		this.imageHeight = 190;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/adminshopblock.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/left_gray_line.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + -20, 0, 0, 100, 24, 100, 24);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/right_gray_line.png"));
		this.blit(ms, this.leftPos + 105, this.topPos + -20, 0, 0, 100, 24, 100, 24);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/mid_gray_line.png"));
		this.blit(ms, this.leftPos + 74, this.topPos + -20, 0, 0, 100, 24, 100, 24);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopblock.label_adminshop_block_menu"), 50, -17, -1);
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
		button_dirt = new Button(this.leftPos + 22, this.topPos + 6, 46, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_dirt"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(0, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_dirt", button_dirt);
		this.addRenderableWidget(button_dirt);
		button_grass = new Button(this.leftPos + 146, this.topPos + 8, 51, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_grass"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(1, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_grass", button_grass);
		this.addRenderableWidget(button_grass);
		button_stone = new Button(this.leftPos + 22, this.topPos + 29, 82, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_stone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(2, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_stone", button_stone);
		this.addRenderableWidget(button_stone);
		button_netherrack = new Button(this.leftPos + 22, this.topPos + 58, 82, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_netherrack"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(3, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_netherrack", button_netherrack);
		this.addRenderableWidget(button_netherrack);
		button_soul_sand = new Button(this.leftPos + 21, this.topPos + 84, 72, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_soul_sand"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(4, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_soul_sand", button_soul_sand);
		this.addRenderableWidget(button_soul_sand);
		button_sand = new Button(this.leftPos + 151, this.topPos + 33, 46, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_sand"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(5, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_sand", button_sand);
		this.addRenderableWidget(button_sand);
		button_gravel = new Button(this.leftPos + 141, this.topPos + 57, 56, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_gravel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(6, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_gravel", button_gravel);
		this.addRenderableWidget(button_gravel);
		button_glowstone = new Button(this.leftPos + 21, this.topPos + 113, 72, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_glowstone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(7, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_glowstone", button_glowstone);
		this.addRenderableWidget(button_glowstone);
		button_oak_wood = new Button(this.leftPos + 21, this.topPos + 141, 66, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_oak_wood"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(8, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_oak_wood", button_oak_wood);
		this.addRenderableWidget(button_oak_wood);
		button_blackstone = new Button(this.leftPos + 120, this.topPos + 84, 77, 20, new TranslatableComponent("gui.palamod.adminshopblock.button_blackstone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(9, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_blackstone", button_blackstone);
		this.addRenderableWidget(button_blackstone);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 182, this.topPos + -15, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(10, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 7, this.topPos + -16, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(11, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}
