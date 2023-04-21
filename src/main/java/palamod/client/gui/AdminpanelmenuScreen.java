
package palamod.client.gui;

import palamod.world.inventory.AdminpanelmenuMenu;

import palamod.network.AdminpanelmenuButtonMessage;

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

public class AdminpanelmenuScreen extends AbstractContainerScreen<AdminpanelmenuMenu> {
	private final static HashMap<String, Object> guistate = AdminpanelmenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_hdv_stocks_panel;
	Button button_money_panel;
	Button button_spawn_panel;
	Button button_trixium_panel;
	Button button_jobs_panel;

	public AdminpanelmenuScreen(AdminpanelmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/adminpanelmenu.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.adminpanelmenu.label_admin_panel"), 52, 5, -65536);
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
		button_hdv_stocks_panel = new Button(this.leftPos + 30, this.topPos + 24, 108, 20, new TranslatableComponent("gui.palamod.adminpanelmenu.button_hdv_stocks_panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuButtonMessage(0, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_hdv_stocks_panel", button_hdv_stocks_panel);
		this.addRenderableWidget(button_hdv_stocks_panel);
		button_money_panel = new Button(this.leftPos + 43, this.topPos + 51, 82, 20, new TranslatableComponent("gui.palamod.adminpanelmenu.button_money_panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuButtonMessage(1, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_money_panel", button_money_panel);
		this.addRenderableWidget(button_money_panel);
		button_spawn_panel = new Button(this.leftPos + 43, this.topPos + 78, 82, 20, new TranslatableComponent("gui.palamod.adminpanelmenu.button_spawn_panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuButtonMessage(2, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_spawn_panel", button_spawn_panel);
		this.addRenderableWidget(button_spawn_panel);
		button_trixium_panel = new Button(this.leftPos + 38, this.topPos + 108, 93, 20, new TranslatableComponent("gui.palamod.adminpanelmenu.button_trixium_panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuButtonMessage(3, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_trixium_panel", button_trixium_panel);
		this.addRenderableWidget(button_trixium_panel);
		button_jobs_panel = new Button(this.leftPos + 48, this.topPos + 135, 77, 20, new TranslatableComponent("gui.palamod.adminpanelmenu.button_jobs_panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuButtonMessage(4, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_jobs_panel", button_jobs_panel);
		this.addRenderableWidget(button_jobs_panel);
	}
}
