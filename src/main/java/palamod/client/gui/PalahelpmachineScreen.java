
package palamod.client.gui;

import palamod.world.inventory.PalahelpmachineMenu;

import palamod.network.PalahelpmachineButtonMessage;

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

public class PalahelpmachineScreen extends AbstractContainerScreen<PalahelpmachineMenu> {
	private final static HashMap<String, Object> guistate = PalahelpmachineMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_menu;
	Button button_close;
	Button button_grinder;
	Button button_palamachine;
	Button button_crusher;
	Button button_forge;
	Button button_uploader;
	Button button_downloader;

	public PalahelpmachineScreen(PalahelpmachineMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/palahelpmachine.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("palamod:textures/screens/golem64.png"));
		this.blit(ms, this.leftPos + 7, this.topPos + 19, 0, 0, 64, 64, 64, 64);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.palahelpmachine.label_palahelp_machine_menu"), 34, 4, -52480);
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
		button_back = new Button(this.leftPos + 7, this.topPos + 85, 50, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(0, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_menu = new Button(this.leftPos + 7, this.topPos + 108, 50, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(1, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_menu", button_menu);
		this.addRenderableWidget(button_menu);
		button_close = new Button(this.leftPos + 7, this.topPos + 131, 50, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_close"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(2, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_close", button_close);
		this.addRenderableWidget(button_close);
		button_grinder = new Button(this.leftPos + 87, this.topPos + 19, 75, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_grinder"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(3, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_grinder", button_grinder);
		this.addRenderableWidget(button_grinder);
		button_palamachine = new Button(this.leftPos + 87, this.topPos + 41, 75, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_palamachine"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(4, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_palamachine", button_palamachine);
		this.addRenderableWidget(button_palamachine);
		button_crusher = new Button(this.leftPos + 87, this.topPos + 63, 75, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_crusher"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(5, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_crusher", button_crusher);
		this.addRenderableWidget(button_crusher);
		button_forge = new Button(this.leftPos + 87, this.topPos + 85, 75, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_forge"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(6, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_forge", button_forge);
		this.addRenderableWidget(button_forge);
		button_uploader = new Button(this.leftPos + 87, this.topPos + 108, 76, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_uploader"), e -> {
		});
		guistate.put("button:button_uploader", button_uploader);
		this.addRenderableWidget(button_uploader);
		button_downloader = new Button(this.leftPos + 87, this.topPos + 130, 75, 20, new TranslatableComponent("gui.palamod.palahelpmachine.button_downloader"), e -> {
		});
		guistate.put("button:button_downloader", button_downloader);
		this.addRenderableWidget(button_downloader);
	}
}
