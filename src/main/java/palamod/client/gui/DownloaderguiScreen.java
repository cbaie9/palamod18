
package palamod.client.gui;

import palamod.world.inventory.DownloaderguiMenu;

import palamod.procedures.Grindertrans0Procedure;

import palamod.network.DownloaderguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class DownloaderguiScreen extends AbstractContainerScreen<DownloaderguiMenu> {
	private final static HashMap<String, Object> guistate = DownloaderguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox download_state;
	Button button_reload;
	Button button_link;

	public DownloaderguiScreen(DownloaderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/downloadergui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/arrow_down_downloader_gray.png"));
		this.blit(ms, this.leftPos + 78, this.topPos + 61, 0, 0, 16, 16, 16, 16);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.downloadergui.label_filter"), 138, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.downloadergui.label_output"), 70, 31, -12829636);
		this.font.draw(poseStack,

				Grindertrans0Procedure.execute(entity), 6, 71, -12829636);
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
		button_reload = new Button(this.leftPos + 113, this.topPos + 58, 56, 20, new TranslatableComponent("gui.palamod.downloadergui.button_reload"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DownloaderguiButtonMessage(0, x, y, z));
				DownloaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_reload", button_reload);
		this.addRenderableWidget(button_reload);
		button_link = new Button(this.leftPos + 3, this.topPos + 48, 46, 20, new TranslatableComponent("gui.palamod.downloadergui.button_link"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DownloaderguiButtonMessage(1, x, y, z));
				DownloaderguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_link", button_link);
		this.addRenderableWidget(button_link);
		download_state = new Checkbox(this.leftPos + 4, this.topPos + 4, 20, 20, new TranslatableComponent("gui.palamod.downloadergui.download_state"), false);
		guistate.put("checkbox:download_state", download_state);
		this.addRenderableWidget(download_state);
	}
}
