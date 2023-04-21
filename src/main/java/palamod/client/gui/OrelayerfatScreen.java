
package palamod.client.gui;

import palamod.world.inventory.OrelayerfatMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class OrelayerfatScreen extends AbstractContainerScreen<OrelayerfatMenu> {
	private final static HashMap<String, Object> guistate = OrelayerfatMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public OrelayerfatScreen(OrelayerfatMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/orelayerfat.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.orelayerfat.label_paladium_64_15"), 4, 57, -3407872);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.orelayerfat.label_titane_64_32"), 5, 69, -10066330);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.orelayerfat.label_amethyst_64_80"), 7, 80, -6750055);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.orelayerfat.label_findium_64_150"), 5, 42, -13312);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.orelayerfat.label_green_paladium_64_128"), 6, 28, -16738048);
		this.font.draw(poseStack, new TranslatableComponent("gui.palamod.orelayerfat.label_endium_64_128_customs_p"), 5, 15, -16777114);
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
	}
}
