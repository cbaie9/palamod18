
package palamod.client.gui;

import palamod.world.inventory.AdminshopmenuMenu;

import palamod.network.AdminshopmenuButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshopmenuScreen extends AbstractContainerScreen<AdminshopmenuMenu> {
	private final static HashMap<String, Object> guistate = AdminshopmenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_admin_btte_ore;
	ImageButton imagebutton_btte_block;
	ImageButton imagebutton_btte_plant;
	ImageButton imagebutton_btte_mobs;
	ImageButton imagebutton_btte_utilities;

	public AdminshopmenuScreen(AdminshopmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 191;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/adminshopmenu.png");

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
		this.blit(ms, this.leftPos + 0, this.topPos + -9, 0, 0, 100, 24, 100, 24);

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/right_gray_line.png"));
		this.blit(ms, this.leftPos + 99, this.topPos + -9, 0, 0, 100, 24, 100, 24);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmenu.label_adminshop"), 69, -3, -1);
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
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 176, this.topPos + -4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(0, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_admin_btte_ore = new ImageButton(this.leftPos + 70, this.topPos + 53, 48, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_admin_btte_ore.png"), 48, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(1, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_admin_btte_ore", imagebutton_admin_btte_ore);
		this.addRenderableWidget(imagebutton_admin_btte_ore);
		imagebutton_btte_block = new ImageButton(this.leftPos + 71, this.topPos + 20, 48, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_btte_block.png"), 48, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(2, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_btte_block", imagebutton_btte_block);
		this.addRenderableWidget(imagebutton_btte_block);
		imagebutton_btte_plant = new ImageButton(this.leftPos + 71, this.topPos + 81, 48, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_btte_plant.png"), 48, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(3, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_btte_plant", imagebutton_btte_plant);
		this.addRenderableWidget(imagebutton_btte_plant);
		imagebutton_btte_mobs = new ImageButton(this.leftPos + 71, this.topPos + 111, 48, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_btte_mobs.png"), 48, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(4, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_btte_mobs", imagebutton_btte_mobs);
		this.addRenderableWidget(imagebutton_btte_mobs);
		imagebutton_btte_utilities = new ImageButton(this.leftPos + 72, this.topPos + 144, 48, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_btte_utilities.png"), 48, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(5, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_btte_utilities", imagebutton_btte_utilities);
		this.addRenderableWidget(imagebutton_btte_utilities);
	}
}
