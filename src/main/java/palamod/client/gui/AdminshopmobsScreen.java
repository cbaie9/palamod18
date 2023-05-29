
package palamod.client.gui;

import palamod.world.inventory.AdminshopmobsMenu;

import palamod.network.AdminshopmobsButtonMessage;

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

public class AdminshopmobsScreen extends AbstractContainerScreen<AdminshopmobsMenu> {
	private final static HashMap<String, Object> guistate = AdminshopmobsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_exit;
	Button button_cactus;
	Button button_red_mushroom;
	Button button_brown_mushroom;
	Button button_warped_fungus;
	Button button_crimson_fungun;
	Button button_potato;
	Button button_wheat_seed;
	Button button_carrot;
	Button button_melon;
	Button button_sugar_cane;
	Button button_next;

	public AdminshopmobsScreen(AdminshopmobsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/adminshopmobs.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminshopmobs.label_adminshop_plant_section"), 12, 5, -52480);
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
		button_back = new Button(this.leftPos + 4, this.topPos + 174, 46, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(0, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_exit = new Button(this.leftPos + 60, this.topPos + 174, 61, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_exit"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(1, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_exit", button_exit);
		this.addRenderableWidget(button_exit);
		button_cactus = new Button(this.leftPos + 11, this.topPos + 104, 38, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_cactus"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(2, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_cactus", button_cactus);
		this.addRenderableWidget(button_cactus);
		button_red_mushroom = new Button(this.leftPos + 93, this.topPos + 26, 87, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_red_mushroom"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(3, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_red_mushroom", button_red_mushroom);
		this.addRenderableWidget(button_red_mushroom);
		button_brown_mushroom = new Button(this.leftPos + 65, this.topPos + 77, 117, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_brown_mushroom"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(4, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_brown_mushroom", button_brown_mushroom);
		this.addRenderableWidget(button_brown_mushroom);
		button_warped_fungus = new Button(this.leftPos + 93, this.topPos + 51, 87, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_warped_fungus"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(5, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_warped_fungus", button_warped_fungus);
		this.addRenderableWidget(button_warped_fungus);
		button_crimson_fungun = new Button(this.leftPos + 8, this.topPos + 134, 74, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_crimson_fungun"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(6, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_crimson_fungun", button_crimson_fungun);
		this.addRenderableWidget(button_crimson_fungun);
		button_potato = new Button(this.leftPos + 11, this.topPos + 51, 56, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_potato"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(7, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_potato", button_potato);
		this.addRenderableWidget(button_potato);
		button_wheat_seed = new Button(this.leftPos + 100, this.topPos + 104, 81, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_wheat_seed"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(8, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_wheat_seed", button_wheat_seed);
		this.addRenderableWidget(button_wheat_seed);
		button_carrot = new Button(this.leftPos + 12, this.topPos + 77, 34, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_carrot"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(9, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_carrot", button_carrot);
		this.addRenderableWidget(button_carrot);
		button_melon = new Button(this.leftPos + 11, this.topPos + 25, 63, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_melon"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(10, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:button_melon", button_melon);
		this.addRenderableWidget(button_melon);
		button_sugar_cane = new Button(this.leftPos + 95, this.topPos + 134, 85, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_sugar_cane"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(11, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:button_sugar_cane", button_sugar_cane);
		this.addRenderableWidget(button_sugar_cane);
		button_next = new Button(this.leftPos + 133, this.topPos + 173, 46, 20, new TranslatableComponent("gui.palamod.adminshopmobs.button_next"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopmobsButtonMessage(12, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
	}
}
