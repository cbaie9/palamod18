
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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshopmenuScreen extends AbstractContainerScreen<AdminshopmenuMenu> {
	private final static HashMap<String, Object> guistate = AdminshopmenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_seed;
	Button button_utilities;
	Button button_mobss_items;
	Button button_block;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_admin_btte_ore;

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
		button_seed = new Button(this.leftPos + 70, this.topPos + 83, 46, 20, new TranslatableComponent("gui.palamod.adminshopmenu.button_seed"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(0, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_seed", button_seed);
		this.addRenderableWidget(button_seed);
		button_utilities = new Button(this.leftPos + 59, this.topPos + 147, 72, 20, new TranslatableComponent("gui.palamod.adminshopmenu.button_utilities"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(1, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_utilities", button_utilities);
		this.addRenderableWidget(button_utilities);
		button_mobss_items = new Button(this.leftPos + 50, this.topPos + 115, 92, 20, new TranslatableComponent("gui.palamod.adminshopmenu.button_mobss_items"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(2, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_mobss_items", button_mobss_items);
		this.addRenderableWidget(button_mobss_items);
		button_block = new Button(this.leftPos + 68, this.topPos + 21, 51, 20, new TranslatableComponent("gui.palamod.adminshopmenu.button_block"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(3, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_block", button_block);
		this.addRenderableWidget(button_block);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 176, this.topPos + -4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(4, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_admin_btte_ore = new ImageButton(this.leftPos + 70, this.topPos + 53, 48, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_admin_btte_ore.png"), 48, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmenuButtonMessage(5, x, y, z));
				AdminshopmenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_admin_btte_ore", imagebutton_admin_btte_ore);
		this.addRenderableWidget(imagebutton_admin_btte_ore);
	}
}
