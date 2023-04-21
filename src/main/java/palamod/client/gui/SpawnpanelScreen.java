
package palamod.client.gui;

import palamod.world.inventory.SpawnpanelMenu;

import palamod.network.SpawnpanelButtonMessage;

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

public class SpawnpanelScreen extends AbstractContainerScreen<SpawnpanelMenu> {
	private final static HashMap<String, Object> guistate = SpawnpanelMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_change_spawn;

	public SpawnpanelScreen(SpawnpanelMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/spawnpanel.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.spawnpanel.label_varcoor_spawn"), 5, 56, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.spawnpanel.label_spawn_panel"), 46, 2, -12829636);
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
		button_change_spawn = new Button(this.leftPos + 3, this.topPos + 74, 92, 20, new TranslatableComponent("gui.palamod.spawnpanel.button_change_spawn"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SpawnpanelButtonMessage(0, x, y, z));
				SpawnpanelButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_change_spawn", button_change_spawn);
		this.addRenderableWidget(button_change_spawn);
	}
}
